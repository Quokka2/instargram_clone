package com.example.instargram.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;
    private String password;
    private String nickname;

    private UserRole role;

    // OAuth 로그인에 사용
    private String provider;
    private String providerId;

    @Builder
    public User(String loginId, String password, String nickname, UserRole role) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }
}