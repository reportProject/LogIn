package net.skhu.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import net.skhu.domain.Professor;
import net.skhu.domain.Student;
import net.skhu.domain.Ta;

/*MyAuthenticationProvier 클래스는
 
사용자가 입력한 로그인 아이디와 비밀번호를 검사할 때 사용되는 클래스이다.*/
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	StudentService studentService;
	@Autowired
	ProfessorService professorService;
	@Autowired
	TaService taService;

	/* 사용자가 입력한 로그인 아이디와 비밀번호가 authenticate 메소드의 파라미터로 전달된다. */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String loginId = authentication.getName();
		String passwd = authentication.getCredentials().toString();
		return authenticate(loginId, passwd);
	}

	public Authentication authenticate(String login_id, String password) throws AuthenticationException {
		Student student = studentService.login(login_id, password);
		if (student == null) {
			return null; // 검사가 실패하면 null을 리턴한다.
		}
		Professor professor = professorService.login(login_id, password);
		if (professor == null) {
			return null;
		}
		Ta ta = taService.login(login_id, password);
		if (ta == null) {
			return null;
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		String role = "";
		if (student != null) {
			role = "ROLE_STUDENT";
		}
		if (professor != null) {
			role = "ROLE_PROFESSOR";
		}
		if (ta != null) {
			role = "ROLE_TA";
		}
//		switch (user.getUserType()) {
//		case "관리자":
//			role = "ROLE_ADMIN";
//			break;
//		case "교수":
//			role = "ROLE_PROFESSOR";
//			break;
//		case "학생":
//			role = "ROLE_STUDENT";
//			break;
//		case "TA":
//			role = "ROLE_TA";
//			break;
//		}
		grantedAuthorities.add(new SimpleGrantedAuthority(role));
		return new MyAuthenticaion(login_id, password, grantedAuthorities, student, professor, ta);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public class MyAuthenticaion extends UsernamePasswordAuthenticationToken {
		private static final long serialVersionUID = 1L;
		Student student;
		Professor professor;
		Ta ta;

		public MyAuthenticaion(String login_id, String password, List<GrantedAuthority> grantedAuthorities,
				Student student, Professor professor, Ta ta) {
			super(login_id, password, grantedAuthorities);
			this.student = student;
			this.professor = professor;
			this.ta = ta;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Professor getProfessor() {
			return professor;
		}

		public void setProfessor(Professor professor) {
			this.professor = professor;
		}

		public Ta getTa() {
			return ta;
		}

		public void setTa(Ta ta) {
			this.ta = ta;
		}

	}
}
