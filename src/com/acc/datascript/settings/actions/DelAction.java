package com.acc.datascript.settings.actions;

import com.acc.datascript.settings.ConnectionInfo;
import com.acc.datascript.settings.DataScriptSettings;
import com.acc.datascript.settings.ServerInfo;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.TreePath;

/**
 * Created by demius on 11.11.2015.
 */
public class DelAction extends AnAction {

    final DataScriptSettings settings;
    final Tree treeView;

    public DelAction(@Nullable String text, @Nullable String description, @Nullable Icon icon, DataScriptSettings settings, Tree treeView) {
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

        if (selectionPathLen == 2) {
            settings.servers.remove(serverInfo);
        } else {
            ConnectionInfo connectionInfo = (ConnectionInfo) components[3];
            serverInfo.connectionInfo.remove(connectionInfo);
        }
        settings.fireTreeStructureChanged();
    }
}
