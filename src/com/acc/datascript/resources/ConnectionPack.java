package com.acc.datascript.resources;

/**
 * Created by demius on 12.11.2015.
 */
public class ConnectionPack {
    public final String serverInfo;
    public final String user;

    public ConnectionPack(String serverInfo, String user) {
        this.serverInfo = serverInfo;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionPack that = (ConnectionPack) o;

        if (!serverInfo.equals(that.serverInfo)) return false;
        return user.equals(that.user);

    }

    @Override
    public int hashCode() {
        int result = serverInfo.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
