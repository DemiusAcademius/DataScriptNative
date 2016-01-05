package com.acc.datascript.settings.dialogs;

import com.acc.datascript.resources.ConnectionManager;
import com.acc.datascript.settings.ConnectionInfo;
import com.acc.datascript.settings.ServerInfo;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by demius on 11.11.2015.
 */
public class ServerInfoDialog extends DialogWrapper {

    private JPanel myPanel = new JPanel(new GridBagLayout());

    private JTextField myOracleUri = new JTextField();
    private JFormattedTextField myOraclePort = new JFormattedTextField();
    private JTextField myOracleUser = new JTextField();
    private JPasswordField myOraclePw = new JPasswordField();
    private JTextField myOracleSid = new JTextField();
    private JButton btTestConnection = new JButton("TEST CONNECTION");

    private final ServerInfo serverInfo;

    public ServerInfoDialog(@Nullable Project project, ServerInfo serverInfo) {
        super(project);
        this.serverInfo = serverInfo;

        String title;
        if (serverInfo == null)
            title = "Add Oracle Server";
        else title = "Edit Oracle Server";

        this.setTitle(title);

        {
            NumberFormat format = NumberFormat.getInstance();
            format.setParseIntegerOnly(true);
            format.setGroupingUsed(false);
            NumberFormatter formatter = new NumberFormatter(format);
            formatter.setValueClass(Integer.class);
            formatter.setMinimum(0);
            formatter.setMaximum(Integer.MAX_VALUE);

            formatter.setCommitsOnValidEdit(true);
            myOraclePort.setFormatterFactory(new DefaultFormatterFactory(formatter));
        }

        btTestConnection.addActionListener( e -> {
            ConnectionManager connectionManager = ConnectionManager.getInstance();
            String result = connectionManager.testConnection(getServerInfo(), new ConnectionInfo(myOracleUser.getText(),String.valueOf(myOraclePw.getPassword())));
            Messages.showMessageDialog(project, result, "Test result", Messages.getInformationIcon());
        });

        if (serverInfo != null) {
            myOracleUri.setText(serverInfo.uri);
            myOracleSid.setText(serverInfo.sid);
            myOraclePort.setValue(serverInfo.port);
        } else {
            myOracleUri.setText("Oracle.apa-canal.md");
            myOracleSid.setText("ACC");
            myOraclePort.setValue(1521);
        }
        myOracleUser.setText("SYSTEM");

        myPanel.add(new JLabel("Uri"), new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));
        myPanel.add(myOracleUri, new GridBagConstraints(1,0,1,1,1.0,0,GridBagConstraints.CENTER,1,new Insets(5,5,5,5), 0, 0));
        myPanel.add(new JLabel("Port"), new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));
        myPanel.add(myOraclePort, new GridBagConstraints(1,1,1,1,1.0,0,GridBagConstraints.CENTER,1,new Insets(5,5,5,5), 0, 0));
        myPanel.add(new JLabel("SID"), new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));
        myPanel.add(myOracleSid, new GridBagConstraints(1,2,1,1,1.0,0,GridBagConstraints.CENTER,1,new Insets(5,5,5,5), 0, 0));
        myPanel.add(new JLabel("Testing user name"), new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));
        myPanel.add(myOracleUser, new GridBagConstraints(1,3,1,1,1.0,0,GridBagConstraints.CENTER,1,new Insets(5,5,5,5), 0, 0));
        myPanel.add(new JLabel("Testing user password"), new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));
        myPanel.add(myOraclePw, new GridBagConstraints(1,4,1,1,1.0,0,GridBagConstraints.CENTER,1,new Insets(5,5,5,5), 0, 0));
        myPanel.add(btTestConnection, new GridBagConstraints(1,5,1,1,1.0,0,GridBagConstraints.WEST,0,new Insets(5,5,5,5), 0, 0));

        myPanel.setMinimumSize(new Dimension(500, 90));

        init();
    }

    public ServerInfo getServerInfo() {
        return new ServerInfo(myOracleUri.getText(), (Integer) myOraclePort.getValue(),myOracleSid.getText());
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return myOracleUri;
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return myPanel;
    }
}
