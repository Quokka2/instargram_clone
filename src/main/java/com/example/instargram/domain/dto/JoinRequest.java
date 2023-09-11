package com.example.instargram.domain.dto;

import com.example.instargram.domain.User;
import com.example.instargram.domain.UserRole;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    private String loginId;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
    private String passwordCheck;

    @NotBlank(message = "닉네임이 비어있습니다.")
    private String nickname;

    //  정적 팩토리 메서드
    public static JoinRequest setEntity(String loginId, String password, String passwordCheck, String nickname) {
        return JoinRequest.builder()
                .loginId(loginId)
                .password(password)
                .passwordCheck(passwordCheck)
                .nickname(nickname)
                .build();
    }

    @Builder
    public JoinRequest(String loginId, String password, String passwordCheck, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.passwordCheck = passwordCheck;
    }

    // 비밀번호 암호화
    public User toEntity(String encodedPassword) {
        return User.builder()
                .loginId(this.loginId)
                .password(encodedPassword)
                .nickname(this.nickname)
                .role(UserRole.USER)
                .build();
    }
}