package com.sbnz.sbnz.domain;

import com.sbnz.sbnz.domain.enumeration.Authority;
import com.sbnz.sbnz.domain.enumeration.MedType;

public class JWTUser {

    private String username;

    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
