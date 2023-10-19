package com.example.instargram.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String email;
    private String nickname;

    public Test(Long id, String password, String email, String nickname) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

    public static Test createTest(Long id, String password, String email, String nickname){
        return new Test(id, password, email, nickname);
    }

    public static Test createTestId(String email, String nickname){
        Test test = new Test();
        test.email = email;
        test.nickname = nickname;
        return test;
    }
}