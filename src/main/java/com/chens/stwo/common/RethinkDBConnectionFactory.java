package com.chens.stwo.common;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class RethinkDBConnectionFactory {
    private String host;

    private int port;

    public RethinkDBConnectionFactory(String host,int port) {
        this.host = host;
        this.port = port;
    }

    public Connection createConnection() {
        return RethinkDB.r.connection().hostname(host).port(port).connect();
    }
}
