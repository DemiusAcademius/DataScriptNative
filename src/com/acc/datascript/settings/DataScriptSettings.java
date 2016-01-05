package com.acc.datascript.settings;

import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by demius on 28.09.2015.
 */

@State(
        name = "DataScriptFxSettings",
        storages = {
                @Storage(id = "dataScriptFx",
                        file = StoragePathMacros.APP_CONFIG + "/dataScriptFx.xml")
        }
)
public class DataScriptSettings implements TreeModel,PersistentStateComponent<DataScriptSettings> {

    private static class ConnectionTreeRoot {}
    private final ConnectionTreeRoot root = new ConnectionTreeRoot();

    private final List<TreeModelListener> treeModelListeners = new ArrayList<>();

    @NotNull
    public ArrayList<ServerInfo> servers = new ArrayList<>();

    public void fireTreeStructureChanged() {
        TreeModelEvent e = new TreeModelEvent(this, new Object[] { root });
        for (TreeModelListener tml : treeModelListeners) tml.treeStructureChanged(e);
    }

    @NotNull
    public static DataScriptSettings getInstance() {
        DataScriptSettings persisted = ServiceManager.getService(DataScriptSettings.class);
        return persisted != null ? persisted : new DataScriptSettings();
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof ConnectionTreeRoot) {
            return servers.get(index);
        } else if (parent instanceof  ServerInfo) {
            return ((ServerInfo)parent).connectionInfo.get(index);
        }
        System.out.println("null child for " + parent);
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof ConnectionTreeRoot) {
            return servers.size();
        } else if (parent instanceof  ServerInfo) {
            return ((ServerInfo)parent).connectionInfo.size();
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return (node instanceof ConnectionInfo);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof ConnectionTreeRoot) {
            return servers.indexOf(child);
        } else if (parent instanceof  ServerInfo) {
            return ((ServerInfo)parent).connectionInfo.indexOf(child);
        }
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        treeModelListeners.add(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        treeModelListeners.remove(l);
    }

    @Nullable
    @Override
    public DataScriptSettings getState() {
        return this;
    }

    @Override
    public void loadState(DataScriptSettings dataScriptSettings) {
        XmlSerializerUtil.copyBean(dataScriptSettings, this);
    }

}
