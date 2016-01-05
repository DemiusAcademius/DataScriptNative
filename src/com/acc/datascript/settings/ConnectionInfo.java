package com.acc.datascript.settings;

import org.jetbrains.annotations.NotNull;

/**
 * Created by demius on 30.07.2015.
 */
public class ConnectionInfo {

    @NotNull
    public String user = "";

    @NotNull
    public String pw = "";

    public String uniqueKey() {
        return user;
    }

    public ConnectionInfo() {}

    public ConnectionInfo(String user, String pw) {
        this.user = user;
        this.pw = pw;
    }

}
