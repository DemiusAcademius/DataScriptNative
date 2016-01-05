package com.acc.datascript.settings.actions;

import com.acc.datascript.settings.ConnectionInfo;
import com.acc.datascript.settings.DataScriptSettings;
import com.acc.datascript.settings.ServerInfo;
import com.acc.datascript.settings.dialogs.ConnectionInfoDialog;
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
public class AddConnectionAction extends AnAction {

    final DataScriptSettings settings;
    final Tree treeView;

    public AddConnectionAction(@Nullable String text, @Nullable String description, @Nullable Icon icon, DataScriptSettings settings, Tree treeView) {
        super(text, description, icon);
        this.settings = settings;
        this.treeView = treeView;
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        TreePath selectionPath = treeView.getSelectionPath();
        if (selectionPath == null) return;

        Project project = event.getData(PlatformDataKeys.PROJECT_CONTEXT);

        Object[] components = selectionPath.getPath();

        ServerInfo serverInfo = (ServerInfo) components[1];

        ConnectionInfoDialog dialog = new ConnectionInfoDialog(project,serverInfo,null);
        dialog.show();
        if (dialog.getExitCode() == 0) {
            ConnectionInfo connectionInfo = dialog.getConnectionInfo();

            if (serverInfo.connectionInfo.stream().filter ( c -> c.user.equals(connectionInfo.user)).count() > 0) {
                Messages.showMessageDialog(project, "Connection Info with specified configuration already exists", "Configuration error", Messages.getErrorIcon());
                return;
            }

            serverInfo.connectionInfo.add(connectionInfo);
            settings.fireTreeStructureChanged();
            treeView.expandPath(selectionPath);
        }

    }
}
