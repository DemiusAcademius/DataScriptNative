package com.acc.datascript.settings;

import com.acc.datascript.Icons;
import com.acc.datascript.settings.actions.AddConnectionAction;
import com.acc.datascript.settings.actions.AddServerAction;
import com.acc.datascript.settings.actions.DelAction;
import com.acc.datascript.settings.actions.EdtAction;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by demius on 11.11.2015.
 */
public class SettingsForm implements Configurable {

    private DataScriptSettings mySettings = DataScriptSettings.getInstance();

    private JPanel myPanel = new JPanel(new FormLayout("fill:pref:grow, right:pref","fill:pref:grow"));

    public SettingsForm() {
        Tree dbTree = new Tree(mySettings);

        dbTree.setBackground(new Color(255, 251, 240));
        dbTree.setRootVisible(false);

        dbTree.setCellRenderer(new ColoredTreeCellRenderer() {

            private SimpleTextAttributes dbConnectionAttributes = new SimpleTextAttributes(SimpleTextAttributes.STYLE_BOLD, Color.BLUE);

            @Override
            public void customizeCellRenderer(@NotNull JTree jTree, Object o, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                if (o instanceof ServerInfo) {
                    this.append(o.toString());
                    this.setIcon(Icons.DB_SCHEMA);
                } else if (o instanceof ConnectionInfo) {
                    ConnectionInfo ci = (ConnectionInfo) o;
                    this.append(ci.user, dbConnectionAttributes);
                    this.setIcon(Icons.CONNECT);
                }
            }
        });

        JBScrollPane scrollPane = new JBScrollPane();
        scrollPane.setViewportView(dbTree);
        scrollPane.setAutoscrolls(true);

        DefaultActionGroup group = new DefaultActionGroup();
        JComponent toolBar = ActionManager.getInstance().createActionToolbar("DataScriptFxSettings", group, false).getComponent();

        group.add(new AddServerAction("Add server", "Add path to Oracle server", AllIcons.General.AddJdk, mySettings));
        group.add(new AddConnectionAction("Add connection", "Add connection to Oracle server", AllIcons.General.Add, mySettings, dbTree));
        group.add(new EdtAction("Edit", "Edit", AllIcons.Actions.Edit, mySettings, dbTree));
        group.add(new DelAction("Remove", "Remove", AllIcons.Actions.Delete, mySettings, dbTree));

        CellConstraints cc = new CellConstraints();

        myPanel.add(scrollPane, cc.xy(1, 1));
        myPanel.add(toolBar, cc.xy(2, 1));
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "DataScriptFx Settings";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return myPanel;
    }

    @Override
    public boolean isModified() {
        return true; // TODO: add undo, redo, reset, apply functions
    }

    @Override
    public void apply() throws ConfigurationException {

    }

    @Override
    public void reset() {

    }

    @Override
    public void disposeUIResources() {

    }
}
