package com.example.instargram.domain.dto;

import com.example.instargram.domain.User;
import com.example.instargram.domain.UserRole;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
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



    public static JoinRequest of(final JoinRequest joinRequest){
        return new JoinRequest(joinRequest.getLoginId(), joinRequest.getPassword(),
                joinRequest.getPasswordCheck(), joinRequest.getNickname());
    }


    private JoinRequest(String loginId, String password, String passwordCheck, String nickname) {
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