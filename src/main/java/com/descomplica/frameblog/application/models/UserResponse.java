package com.descomplica.frameblog.application.models;

import com.descomplica.frameblog.domain.enums.Role;

public record UserResponse(Long id, String name, String email, Role role) {
}
