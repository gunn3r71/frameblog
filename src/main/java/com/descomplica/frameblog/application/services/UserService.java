package com.descomplica.frameblog.application.services;

import com.descomplica.frameblog.application.models.CreateUserRequest;
import com.descomplica.frameblog.application.models.UpdateUserRequest;
import com.descomplica.frameblog.application.models.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    UserResponse getUserById(Long id);
    void updateUser(Long id, UpdateUserRequest request);
    List<UserResponse> getUsers();

    void deleteUser(Long id);
}
