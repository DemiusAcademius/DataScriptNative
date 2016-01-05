package com.acc.datascript.settings.dialogs;

import com.acc.datascript.resources.ConnectionManager;
import com.acc.datascript.settings.ConnectionInfo;
import com.acc.datascript.settings.ServerInfo;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by demius on 11.11.2015.
 */
public class ConnectionInfoDialog extends DialogWrapper {

    final ServerInfo serverInfo;
    final ConnectionInfo connectionInfo;

    private JPanel myPanel = new JPanel(new GridBagLayout());

    private JTextField myOracleUser = new JTextField();
    private JPasswordField myOraclePw = new JPasswordField();
    private JButton btTestConnection = new JButton("TEST CONNECTION");

    public ConnectionInfoDialog(@Nullable Project project, ServerInfo serverInfo, ConnectionInfo connectionInfo) {
        super(project);
        this.serverInfo = serverInfo;
        this.connectionInfo = connectionInfo;

        String title;
        if (connectionInfo == null)
            title = "Add Connection to Oracle Server";
        else title = "Edit Connection to Oracle Server";

        this.setTitle(title);

        btTestConnection.addActionListener(e -> {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            String result = connectionManager.testConnection(serverInfo, getConnectionInfo());
            Messages.showMessageDialog(project, result, "Test result", Messages.getInformationIcon());
        });

        if (connectionInfo != null) {
            myOracleUser.setText(connectionInfo.user);
            myOraclePw.setText(connectionInfo.pw);
        }

        myPanel.add(new JLabel("User name"), new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));
        myPanel.add(myOracleUser, new GridBagConstraints(1,0,1,1,1.0,0,GridBagConstraints.CENTER,1,new Insets(5,5,5,5), 0, 0));
        myPanel.add(new JLabel("User password"), new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));
        myPanel.add(myOraclePw, new GridBagConstraints(1,1,1,1,1.0,0,GridBagConstraints.CENTER,1,new Insets(5,5,5,5), 0, 0));
        myPanel.add(btTestConnection, new GridBagConstraints(1,2,1,1,1.0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));

        myPanel.setMinimumSize(new Dimension(500, 90));

        init();
    }

    public ConnectionInfo getConnectionInfo() {
        return new ConnectionInfo(myOracleUser.getText(),String.valueOf(myOraclePw.getPassword()));
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return myOracleUser;
    }


    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return myPanel;
    }
}
