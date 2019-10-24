package net.skhu.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ProfessorController {

	@RequestMapping("professor/index")
	public String index() {
		return "professor/index"; // 로그인 한 교수를 위한 첫 페이지 URL
	}
}
