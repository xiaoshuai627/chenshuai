package com.chens.stwo.pojo;


public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gtmcreate;
    private Long gtmmodify;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account_id='" + account_id + '\'' +
                ", token='" + token + '\'' +
                ", gtmcreate=" + gtmcreate +
                ", gtmmodify=" + gtmmodify +
                '}';
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGtmcreate() {
        return gtmcreate;
    }

    public void setGtmcreate(Long gtmcreate) {
        this.gtmcreate = gtmcreate;
    }

    public Long getGtmmodify() {
        return gtmmodify;
    }

    public void setGtmmodify(Long gtmmodify) {
        this.gtmmodify = gtmmodify;
    }
}
