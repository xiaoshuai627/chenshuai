package com.chens.stwo.controller;

import com.chens.stwo.config.RethinkDBConfiguration;
import com.chens.stwo.pojo.RdbTest;
import com.rethinkdb.RethinkDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RethinkDBController {

    @Autowired
    private RethinkDBConfiguration dbConfiguration;

    private static final RethinkDB r = RethinkDB.r;

    static {
         RdbTest d = RdbTest.builder()
                .id(1)
                .appName("hello")
                .creator("xiaoshuai").build();
    }


    @GetMapping(value = "/rlist")
    public String rListDB() {
       RdbTest rdbTest = r.db("test").table("xiaoshuai")
               .run(dbConfiguration.connectionFactory().createConnection(),RdbTest.class);
       return  rdbTest.toString();
    }
}
