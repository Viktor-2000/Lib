package com.example.springBootdemo.model;

public enum Permission {
    USER_READ("user:read"),
    USER_LIBRARIAN("user:librarian");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
