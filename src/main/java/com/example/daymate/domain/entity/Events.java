package com.example.daymate.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
public class Events {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private Integer id;

    @Setter @Column(length = 200, nullable = false) private String title;
    @Setter @Column(length = 14, nullable = false) private String eventAt;

    @Column(columnDefinition = "VARCHAR(1) NOT NULL DEFAULT('N') ") private String completeYn;
    @Column(columnDefinition = "VARCHAR(1) NOT NULL DEFAULT('Y') ") private String alertYn;

    @Column(length = 14, nullable = false) private String createdAt;
    @Column(length = 14) private String updatedAt;
    @Column(length = 14) private String deletedAt;

    // fk
    @Column (name = "USER_ID") private Integer userId;


    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        createdAt = now.format(formatter);
    }

    protected Events() {}

    private Events(String title, String eventAt) {
        this.title = title;
        this.eventAt = eventAt;
    }

    public static Events of(String title, String eventAt) {
        return new Events(title, eventAt);
    }

}