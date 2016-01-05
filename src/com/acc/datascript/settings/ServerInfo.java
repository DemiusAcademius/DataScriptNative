package com.acc.datascript.settings;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Created by demius on 31.07.2015.
 */
public class ServerInfo {

    @NotNull
    public String uri = "";

    @NotNull
    public int port = 1521;

    @NotNull
    public String sid = "";

    @NotNull
    public ArrayList<ConnectionInfo> connectionInfo = new ArrayList<>();

    @Override
    public String toString() {
        return uri + ":" + port +":" + sid;
    }

    public ServerInfo() {}

    public ServerInfo(String uri, int port, String sid) {
        this.uri = uri;
        this.port = port;
        this.sid = sid;
    }
}
