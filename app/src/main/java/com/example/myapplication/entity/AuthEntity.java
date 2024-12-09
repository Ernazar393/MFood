package com.example.myapplication.entity;

public class AuthEntity {
    private String key;
    private String login;
    private String pass;

    public AuthEntity() {
        super();
    }

    public AuthEntity(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
