package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository;
import net.skhu.utils.EncryptionUtils;

@Service("studentService")
public class StudentService {

	@Autowired StudentRepository studentRepository;

	/*
	 * login 메소드
	 * 
	 * 사용자가 입력한 로그인 아이디와 비밀번호를 검사하는 메소드
	 */
	public Student login(String studentId, String password) {
		Student student = studentRepository.findOneByStudentId(studentId);
		if(student == null) {
			return null;
		}
		String pw=EncryptionUtils.encryptMD5(password);
		if(student.getPassword().equals(pw)==false) {
			return null;
		}
		return student;
	}
}
