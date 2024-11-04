package com.descomplica.frameblog.domain.enums;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private final String Role;

    Role(String role) {
        Role = role;
    }

    public String getRole() {
        return Role;
    }
}
