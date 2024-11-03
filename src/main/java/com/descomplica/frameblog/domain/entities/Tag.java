package com.descomplica.frameblog.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}
