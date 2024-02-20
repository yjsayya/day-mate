package com.example.daymate.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
public class Follows implements Serializable {

    @EmbeddedId
    private FollowsCompositeKey id;

    @Column(columnDefinition = "VARCHAR(1) NOT NULL DEFAULT 'Y' ") private String followYn;

    @Column(length = 14, nullable = false) String createdAt;
    @Column(length = 14) String updatedAt;


    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        createdAt = now.format(formatter);
    }

    protected Follows() {}

    private Follows(FollowsCompositeKey followsCompositeKey) {
        this.id = followsCompositeKey;
    }

    public static Follows of(FollowsCompositeKey followsCompositeKey) {
        return new Follows(followsCompositeKey);
    }

}