package net.skhu.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class StudentController {

	@RequestMapping("student/index")
	public String index() {
		return "student/index"; // 로그인 한 학생을 위한 첫 페이지 URL
	}
}
