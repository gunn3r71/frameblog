package com.descomplica.frameblog.infrastructure.database.repositories;

import com.descomplica.frameblog.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u where u.email = :email")
    User findByUsername(@Param("email") String email);
}