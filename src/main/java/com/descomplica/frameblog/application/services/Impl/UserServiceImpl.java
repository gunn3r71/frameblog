package com.descomplica.frameblog.application.services.Impl;

import com.descomplica.frameblog.application.mappings.DtoToEntityMapping;
import com.descomplica.frameblog.application.mappings.EntityToDtoMapping;
import com.descomplica.frameblog.application.models.CreateUserRequest;
import com.descomplica.frameblog.application.models.UpdateUserRequest;
import com.descomplica.frameblog.application.models.UserResponse;
import com.descomplica.frameblog.application.services.UserService;
import com.descomplica.frameblog.infrastructure.database.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        if (request.name().isEmpty() || request.email().isEmpty() || request.password().isEmpty())
            throw new IllegalArgumentException();

        var existentUser = repository.findByUsername(request.email());

        if (Objects.nonNull(existentUser))
            throw new RuntimeException("User already exists");

        var user = repository.saveAndFlush(DtoToEntityMapping.ToUser(request));

        return EntityToDtoMapping.ToDto(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        var user = repository.findById(id).orElse(null);

        if (Objects.isNull(user))
            return null;

        return EntityToDtoMapping.ToDto(user);
    }

    @Override
    public void updateUser(Long id, UpdateUserRequest request) {
        var user = repository.findById(id).orElseThrow();

        if (request.email().isEmpty() || request.name().isEmpty())
            throw new IllegalArgumentException();

        user.setEmail(request.email());
        user.setName(request.name());

        repository.saveAndFlush(user);
    }

    @Override
    public List<UserResponse> getUsers() {
        return repository.findAll().stream().map(EntityToDtoMapping::ToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}