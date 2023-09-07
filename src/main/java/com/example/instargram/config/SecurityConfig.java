package com.example.instargram.config;

import com.example.instargram.domain.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
				.failureUrl("/security-login/login")
				.and()
				.logout()
				.logoutUrl("/security-login/logout")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID");
		return http.build();

	}
}
