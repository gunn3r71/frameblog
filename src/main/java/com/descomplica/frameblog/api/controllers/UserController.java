package com.descomplica.frameblog.api.controllers;

import com.descomplica.frameblog.application.models.CreateUserRequest;
import com.descomplica.frameblog.application.models.UpdateUserRequest;
import com.descomplica.frameblog.application.models.UserResponse;
import com.descomplica.frameblog.application.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        try {
            UserResponse response = service.createUser(request);
            return ResponseEntity.created(URI.create("/users/"+response.id())).body(response);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse response = service.getUserById(id);

        if (response == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        try {
            return ResponseEntity.ok(service.getUsers());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        try {
            service.updateUser(id, request);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Invalid request body");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Oops, something went wrong");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            service.deleteUser(id);

            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Oops, something went wrong");
        }
    }
}
