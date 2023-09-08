package com.example.instargram.config;

import com.example.instargram.config.auth.PrincipalDetailsService;
import com.example.instargram.domain.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration //빈등록 (IoC관리)
@EnableWebSecurity //security 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근하면 권한 및 인증을 미리 체크하겠다는 뜻
@RequiredArgsConstructor
public class SecurityConfig {

	private final PrincipalDetailsService principalDetailsService;
	private final AuthenticationFailureHandler userLoginFailHandler;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/img/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/security-login/info").authenticated()
				.antMatchers("/security-login/admin/**").hasAuthority(UserRole.ADMIN.name())
				.anyRequest().permitAll()
				.and()
				.formLogin()
				.usernameParameter("loginId")
				.passwordParameter("password")
				.loginPage("/security-login/login")
				.defaultSuccessUrl("/security-login")
				.failureUrl("/security-login/auth/login")
				.failureHandler(userLoginFailHandler)
				.and()
				.logout()
				.logoutUrl("/security-login/logout")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID");
		return http.build();

	}
}
