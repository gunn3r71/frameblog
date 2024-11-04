package com.descomplica.frameblog.infrastructure.database.repositories;

import com.descomplica.frameblog.domain.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
