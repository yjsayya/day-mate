package com.example.daymate.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class FollowsCompositeKey implements Serializable {

    @Column(nullable = false) private Integer userId;
    @Column(nullable = false) private Integer followId;

    protected FollowsCompositeKey() {}

    private FollowsCompositeKey(Integer userId, Integer followId) {
        this.userId = userId;
        this.followId = followId;
    }

    public static FollowsCompositeKey of(Integer userId, Integer followId) {
        return new FollowsCompositeKey(userId, followId);
    }

}