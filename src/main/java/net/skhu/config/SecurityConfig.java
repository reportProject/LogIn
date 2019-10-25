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
		web.ignoring().antMatchers("/res/**"); 
		// /res/** 패턴의 URL은 보안 검사를 하지 말고 무시하라는 설정
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //권한 설정 시작
		.antMatchers("/professor/**").access("ROLE_PROFESSOR") // /professor/** 패턴의 URL은 ROLE_PROFESSOR 권한을 소유한 사용자만 요청할 수 있다는 설정이다.
		.antMatchers("/student/**").access("ROLE_STUDENT") // /student/** 패턴의 URL은 ROLE_STUDENT 권한을 소유한 사용자만 요청할 수 있다는 설정이다.
		.antMatchers("/ta/**").access("ROLE_TA") // /ta/** 패턴의 URL은 ROLE_TA 권한을 소유한 사용자만 요청할 수 있다는 설정이다.
		.antMatchers("/guest/**").permitAll() // /guest/** 패턴의 URL은 모든 사용자에게 허용된다는 설정이다. 로그인하지 않은 사용자에게도 허용된다.
		.antMatchers("/").permitAll() // / URL 은 모든 사용자에게 허용된다는 설정이다. 로그인하지 않은 사용자에게도 허용된다
		.antMatchers("/**").authenticated(); // /** 패턴의 URL은 로그인된 사용자에게만 허용된다는 설정이다.

		http.csrf().disable(); //CSRF 공격 검사를 하지 않겠다는 설정이다.
		
		http.formLogin() //로그인 페이지 설정 시작
		.loginPage("/guest/login") //로그인 페이지 URL 설정
		.loginProcessingUrl("/guest/login_processing") //로그인 페이지에서 '로그인' 버튼(submit button)을 눌렀을 때 요청할 URL 설정
		.failureUrl("/guest/login?error") //로그인이 실패했을 때 넘어갈(redirect) URL 설정
		.defaultSuccessUrl("/user/index", true) //로그인이 성공했을 때 넘어갈(redirect) URL 설정
		.usernameParameter("loginId")
		.passwordParameter("passwd"); //로그인 페이지 (뷰 파일)에서 로그인 아이디 input 태그의 name 값과, 비밀번호 input 태그의 name 값 설정

		http.logout() //로그아웃 설정 시작
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing")) //로그아웃 버튼이나 링크를 눌렀을 때 요청할 URL 설정
		.logoutSuccessUrl("/guest/login") //로그아웃된 후 넘어갈(redirect) URL 설정
		.invalidateHttpSession(true); //로그아웃할 때, 세션(session)에 들어있는 데이터를 전부 지우라는 설정

		////// 기능은 이하 동일
		http.formLogin() //학생
		.loginPage("/guest/login")
		.loginProcessingUrl("/guest/login_processing")
		.failureUrl("/guest/login?error")
		.defaultSuccessUrl("/student/index", true)
		.usernameParameter("loginId")
		.passwordParameter("passwd");
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/student/logout_processing"))
		.logoutSuccessUrl("/guest/login")
		.invalidateHttpSession(true);
		
		http.formLogin() // 교수
		.loginPage("/guest/login")
		.loginProcessingUrl("/guest/login_processing")
		.failureUrl("/guest/login?error")
		.defaultSuccessUrl("/professor/index", true)
		.usernameParameter("loginId")
		.passwordParameter("passwd");
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/professor/logout_processing"))
		.logoutSuccessUrl("/guest/login")
		.invalidateHttpSession(true);
		
		http.formLogin() // ta
		.loginPage("/guest/login")
		.loginProcessingUrl("/guest/login_processing")
		.failureUrl("/guest/login?error")
		.defaultSuccessUrl("/ta/index", true)
		.usernameParameter("loginId")
		.passwordParameter("passwd");
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/ta/logout_processing"))
		.logoutSuccessUrl("/guest/login")
		.invalidateHttpSession(true);
		
		http.authenticationProvider(myAuthenticationProvider);
	}
}
