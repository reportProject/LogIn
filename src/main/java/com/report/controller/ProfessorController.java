package com.report.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProfessorController {

//	ProfessorRepository repository;

	@RequestMapping("professor/index")
	public String index() {
		return "professor/index"; // 로그인한 professor 사용자를 위한 첫 페이지 URL
	}

//	@RequestMapping("professor/login_processing")
//	public String mainPage(LoginRequest request, Session session) {
//		repository.findByUsername(request.getUsername);
//		
//		session.add("login", true);
//		
//		if (fail) {
//			return "professor/login?error";	
//		}
//		
//		return "professor/mainPage";
//	}
//	
//	@RequestMapping()
//	public String otherPage(Session session) {
//		if (session.get("login") != null && (boolean) ) {
//			return "login";
//		}
//		

}
