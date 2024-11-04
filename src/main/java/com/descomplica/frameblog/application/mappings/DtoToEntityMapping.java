package com.descomplica.frameblog.application.mappings;

import com.descomplica.frameblog.application.models.CreateUserRequest;
import com.descomplica.frameblog.domain.entities.User;

public class DtoToEntityMapping {
    public static User ToUser(CreateUserRequest request) {
        return new User(request.name(),
                        request.email(),
                        request.password(),
                        request.role());
    }
}
