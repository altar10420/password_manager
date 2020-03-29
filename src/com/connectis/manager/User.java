package com.connectis.manager;

public class User {

    public User(String login) {
        this.login = login;
    }

    private String login;

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "login='" + login + "'}";
    }
}
