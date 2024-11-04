package com.descomplica.frameblog.application.mappings;

import com.descomplica.frameblog.application.models.UserResponse;
import com.descomplica.frameblog.domain.entities.User;

public class EntityToDtoMapping {
    public static UserResponse ToDto(User user) {
        return new UserResponse(user.getId(),
                                user.getName(),
                                user.getEmail(),
                                user.getRole());
    }
}
