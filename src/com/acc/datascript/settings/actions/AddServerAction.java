package com.acc.datascript.settings.actions;

import com.acc.datascript.settings.DataScriptSettings;
import com.acc.datascript.settings.ServerInfo;
import com.acc.datascript.settings.dialogs.ServerInfoDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by demius on 11.11.2015.
 */
public class AddServerAction extends AnAction {

    final DataScriptSettings settings;

    public AddServerAction(@Nullable String text, @Nullable String description, @Nullable Icon icon, DataScriptSettings settings) {
        super(text, description, icon);
        this.settings = settings;
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT_CONTEXT);

        ServerInfoDialog dialog = new ServerInfoDialog(project, null);
        dialog.show();
        if (dialog.getExitCode() == 0) {
            ServerInfo serverInfo = dialog.getServerInfo();

            if (settings.servers.stream().filter( s -> s.toString().equals(serverInfo.toString())).count() > 0) {
                Messages.showMessageDialog(project, "Server Info with specified configuration already exists", "Configuration error", Messages.getErrorIcon());
                return;
            }

            settings.servers.add(serverInfo);
            settings.fireTreeStructureChanged();
        }
    }
}
