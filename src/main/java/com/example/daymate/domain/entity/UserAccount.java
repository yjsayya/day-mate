package com.example.daymate.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
public class UserAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer id;

    @Setter @Column(nullable = false, length = 50) private String userEmail;
    @Setter @Column(nullable = false, length = 50) private String userPw;
    @Setter @Column(nullable = false, length = 20, unique = true) private String userName;

    @Column(length = 14, nullable = false) private String createdAt;
    @Column(length = 14) private String updatedAt;
    @Column(length = 14) private String deletedAt;

    @Column(length = 254) private String imgUrl;


    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        createdAt = now.format(formatter);
    }

    protected UserAccount() {}

    private UserAccount(String userEmail, String userPw, String userName) {
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.userName = userName;
    }

    public static UserAccount of(String userEmail, String userPw, String userName) {
        return new UserAccount(userEmail, userPw, userName);
    }

}