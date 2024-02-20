package com.example.daymate.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class EventContent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_CONTENT_ID")
    private Integer id;

    @Setter @Column(nullable = false, length = 200) private String content;

    // fk
    @Column(nullable = false) private Integer eventId;


    protected EventContent() {}

    private EventContent(String content) {
        this.content = content;
    }

    public static EventContent of(String content) {
        return new EventContent(content);
    }

}