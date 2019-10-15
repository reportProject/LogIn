package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.skhu.service.MyAuthenticationProvider;

//spring security 설정을 위한 Java Config 클래스
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/res/**"); // /res/** 패턴의 URL은 보안 검사를 하지 말고 무시하라는 설정
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/**").access("ROLE_ADMIN")
		.antMatchers("/professor/**").access("ROLE_PROFESSOR")
		.antMatchers("/guest/**").permitAll()
		.antMatchers("/").permitAll()
				.antMatchers("/**").authenticated();

		http.csrf().disable();

		http.formLogin().loginPage("/guest/login").loginProcessingUrl("/guest/login_processing")
				.failureUrl("/guest/login?error").defaultSuccessUrl("/user/index", true).usernameParameter("loginId")
				.passwordParameter("passwd");

		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing"))
				.logoutSuccessUrl("/guest/login").invalidateHttpSession(true);

		http.authenticationProvider(myAuthenticationProvider);
	}
}
