package com.acc.datascript.settings.actions;

import com.acc.datascript.settings.ConnectionInfo;
import com.acc.datascript.settings.DataScriptSettings;
import com.acc.datascript.settings.ServerInfo;
import com.acc.datascript.settings.dialogs.ConnectionInfoDialog;
import com.acc.datascript.settings.dialogs.ServerInfoDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.TreePath;

/**
 * Created by demius on 11.11.2015.
 */
public class EdtAction extends AnAction {

    final DataScriptSettings settings;
    final Tree treeView;

    public EdtAction(@Nullable String text, @Nullable String description, @Nullable Icon icon, DataScriptSettings settings, Tree treeView) {
        super(text, description, icon);
        this.settings = settings;
        this.treeView = treeView;
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        TreePath selectionPath = treeView.getSelectionPath();
        if (selectionPath == null) return;

        Object[] components = selectionPath.getPath();
        int selectionPathLen = components.length;

        ServerInfo serverInfo = (ServerInfo) components[1];

        Project project = event.getData(PlatformDataKeys.PROJECT_CONTEXT);

        if (selectionPathLen == 2) {
            // edit server info
            ServerInfoDialog dialog = new ServerInfoDialog(project, serverInfo);
            dialog.show();
            if (dialog.getExitCode() == 0) {
                ServerInfo newServerInfo = dialog.getServerInfo();

                if (!newServerInfo.toString().equals(serverInfo.toString())) {
                    if (settings.servers.stream().filter(s -> s != serverInfo && s.toString().equals(serverInfo.toString())).count() > 0) {
                        Messages.showMessageDialog(project, "Server Info with specified configuration already exists", "Configuration error", Messages.getErrorIcon());
                        return;
                    }

                    serverInfo.port = newServerInfo.port;
                    serverInfo.sid = newServerInfo.sid;
                    serverInfo.uri = newServerInfo.uri;

                    settings.fireTreeStructureChanged();
                    treeView.expandPath(selectionPath);
                }
            }
            // end edit server info
        } else {
            ConnectionInfo connectionInfo = (ConnectionInfo) components[2];
            // edit connection info
            ConnectionInfoDialog dialog = new ConnectionInfoDialog(project, serverInfo, connectionInfo);
            dialog.show();
            if (dialog.getExitCode() == 0) {
                ConnectionInfo newConnectionInfo = dialog.getConnectionInfo();

                if (serverInfo.connectionInfo.stream().filter(c -> c != connectionInfo && c.user.equals(connectionInfo.user)).count() > 0) {
                    Messages.showMessageDialog(project, "Connection Info with specified configuration already exists", "Configuration error", Messages.getErrorIcon());
                    return;
                }

                connectionInfo.user = newConnectionInfo.user;
                connectionInfo.pw = newConnectionInfo.pw;
                settings.fireTreeStructureChanged();
                treeView.expandPath(selectionPath);
            }
            // end edit connection info
        }
    }
}
