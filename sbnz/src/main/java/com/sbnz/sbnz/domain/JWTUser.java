package com.sbnz.sbnz.domain;

public class JWTUser {

    private String username;

    public JWTUser() {}

    public JWTUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return username.equals(((JWTUser)obj).getUsername());
    }
}
