package com.acc.datascript.resources;

import com.acc.datascript.settings.ConnectionInfo;
import com.acc.datascript.settings.DataScriptSettings;
import com.acc.datascript.settings.ServerInfo;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.*;

/**
 * Created by demius on 11.11.2015.
 */
public class ConnectionManager implements ApplicationComponent {

    private static final String SQL_SCHEMAS = "select USERNAME from sys.all_users where USERNAME not in ('SYS','SYSTEM') and instr(USERNAME,'$') = 0 order by USERNAME";
    private static final String SQL_TABLES = "select TABLE_NAME from sys.all_tables t where OWNER = ? and not (TABLE_NAME like 'PBCA%') order by TABLE_NAME";
    private static final String SQL_VIEWS = "SELECT VIEW_NAME FROM SYS.ALL_VIEWS WHERE OWNER = ? order by VIEW_NAME";
    private static final String SQL_COLUMNS = "select column_name, data_type, data_precision, data_scale, nullable from SYS.ALL_TAB_COLUMNS where owner = ? and table_name = ? order by column_id";
    private static final String SQL_SEQUENCES = "select SEQUENCE_NAME from sys.all_sequences where SEQUENCE_OWNER = ?";

    DataScriptSettings mySettings = null;

    public static ConnectionManager getInstance() {
        return ApplicationManager.getApplication().getComponent(ConnectionManager.class);
    }

    private URLClassLoader cl = null;
    private Driver oracleDriver = null;

    @Override
    public void initComponent() {
        String driverStr = "META-INF/drivers/oracle12.jar";

        try {
            Enumeration<URL> enn = getClass().getClassLoader().getResources(driverStr);
            if (enn.hasMoreElements()) {
                URL driverUrl = enn.nextElement();
                cl = URLClassLoader.newInstance(new URL[] { driverUrl});
                Class<Driver> oracleDriverClass = (Class<Driver>) cl.loadClass("oracle.jdbc.driver.OracleDriver");
                oracleDriver = oracleDriverClass.newInstance();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mySettings = DataScriptSettings.getInstance();
    }

    @Override
    public void disposeComponent() {
        if (cl != null) try {
            cl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cl = null;
        oracleDriver = null;
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "DataScriptFxConnectionManager";
    }

    public List<ConnectionPack> getConnections() {
        List<ConnectionPack> connections = new ArrayList<>();

        mySettings.servers.forEach(s -> {
            if (s.sid != null && !s.sid.isEmpty() && s.uri != null && !s.uri.isEmpty())
                s.connectionInfo.forEach(c -> {
                    if (c.user != null && !c.user.isEmpty() && c.pw != null && !c.pw.isEmpty()) {
                        connections.add(new ConnectionPack(s.toString(), c.user));
                    }
                });
        });

        return connections;
    }

    public Connection connect(ServerInfo serverInfo, ConnectionInfo connectionInfo) throws SQLException {
        String connectString = "jdbc:oracle:thin:@"
                + serverInfo.uri
                + ":" + serverInfo.port
                + ":" + serverInfo.sid;

        if (oracleDriver != null) {
            Properties info = new Properties();
            info.setProperty("user", connectionInfo.user);
            info.setProperty("password", connectionInfo.user);

            Connection connection = oracleDriver.connect(connectString, info);
            connection.setAutoCommit(false);
            return connection;
        }
        return null;
    }

    public String testConnection(ServerInfo serverInfo, ConnectionInfo connectionInfo) {
        try (Connection connection = connect(serverInfo, connectionInfo);
             PreparedStatement st = connection.prepareStatement("SELECT 1 FROM DUAL");
             ResultSet rs = st.executeQuery()) {
            rs.next();
            return "Connection success";
        } catch (SQLException ex) {
            return ex.getMessage();
        } catch (Exception ex1) {
            return ex1.getMessage();
        }
    }

    private Connection getConnection(ConnectionPack connectionPack) throws SQLException {
        Optional<ServerInfo> serverInfoOptional = mySettings.servers.stream().filter(s -> s.toString().equals(connectionPack.serverInfo)).findFirst();
        if (serverInfoOptional.isPresent()) {
            ServerInfo serverInfo = serverInfoOptional.get();
            Optional<ConnectionInfo> connectionInfoOptional = serverInfo.connectionInfo.stream().filter(c -> c.user.equals(connectionPack.user)).findFirst();
            if (connectionInfoOptional.isPresent()) {
                ConnectionInfo connectionInfo = connectionInfoOptional.get();
                return connect(serverInfo, connectionInfo);
            }
        }
        throw new SQLException("Not found connection");
    }

    public List<String> getSchemas(ConnectionPack connectionPack) {
        try (Connection connection = getConnection(connectionPack)) {
            return SqlRuntime.fetchList(connection, SQL_SCHEMAS, rs -> rs.getString(1), null, 10);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private List<String> getSchemaElements(ConnectionPack connectionPack, String schema, String sql) {
        try (Connection connection = getConnection(connectionPack)) {
            return SqlRuntime.fetchList(connection, sql, rs -> rs.getString(1), st -> st.setString(1, schema), 10);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<String> getSequences(ConnectionPack connectionPack, String schema) {
        return getSchemaElements(connectionPack, schema, SQL_SEQUENCES);
    }

    public List<String> getTables(ConnectionPack connectionPack, String schema) {
        return getSchemaElements(connectionPack, schema, SQL_TABLES);
    }

    public List<String> getViews(ConnectionPack connectionPack, String schema) {
        return getSchemaElements(connectionPack, schema, SQL_VIEWS);
    }

    public Table getTable(ConnectionPack connectionPack, String schema, String tableName) {
        try (Connection connection = getConnection(connectionPack)) {
            return new Table(schema, tableName,
                    SqlRuntime.fetchList(connection, SQL_COLUMNS, rs -> new Column(rs), st -> {
                                st.setString(1, schema);
                                st.setString(2, tableName);
                            }, 10
                    ), connection);
        } catch (Exception e) {
            return null;
        }
    }

    public View getView(ConnectionPack connectionPack, String schema, String viewName) {
        try (Connection connection = getConnection(connectionPack)) {
            return new View(schema, viewName,
                    SqlRuntime.fetchList(connection, SQL_COLUMNS, rs -> new Column(rs), st -> {
                        st.setString(1, schema);
                        st.setString(2, viewName);
                    }, 10));
        } catch (Exception e) {
            return null;
        }
    }

}
