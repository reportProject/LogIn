package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired StudentRepository studentRepository;

	/*
	 * login 메소드
	 * 
	 * 사용자가 입력한 로그인 아이디와 비밀번호를 검사하는 메소드
	 */
	public Student login(String studentId, String password) {
		Student student = studentRepository.findByStudentId(studentId);
		if(student == null) {
			System.out.println("학생에 입력된 id 값은" + studentId);
			return null;
		}
		System.out.println(student.toString());

		String pw = password;
		if (!student.getPassword().equals(pw)) {
			return null;
		}
		return student;
	}
}
