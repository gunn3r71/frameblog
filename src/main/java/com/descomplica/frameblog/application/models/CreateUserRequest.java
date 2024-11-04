package com.descomplica.frameblog.application.models;

import com.descomplica.frameblog.domain.enums.Role;

public record CreateUserRequest(String name, String email, String password, Role role) {
}
