package com.example.instargram;

import com.example.instargram.domain.User;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginDto {

    private String email;
    private String password;
    private String phone;
    private String username;

    public UserLoginDto(String email, String password, String phone, String username) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.username = username;
    }
    public User toEntity(String encPassword){
        return User.builder()
                .email(email)
                .password(encPassword)
                .phone(phone)
                .username(username)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .phone(phone)
                .username(username)
                .build();
    }
}