package com.example.instargram;

import com.example.instargram.domain.User;
import com.example.instargram.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User signup(UserLoginDto userLoginDto) {

        if (userRepository.findByEmail(userLoginDto.getEmail()) != null) {
            return null;
        }

        //String rawPassword = user.getPassword();
        //String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        //user.setPassword(encPassword);

        User userEntity = userRepository.save(User.builder()
                .email(userLoginDto.getEmail())
                .password(bCryptPasswordEncoder.encode(userLoginDto.getPassword()))
                .phone(userLoginDto.getPhone())
                .username(userLoginDto.getUsername())
                .title(null)
                .website(null)
                .profileImgUrl("/img/default_profile.png")
                .build());

        return userEntity;
    }
}