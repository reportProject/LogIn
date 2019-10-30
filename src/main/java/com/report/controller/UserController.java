package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("student/studentMain")
	public String studentMain() {
		return "student/studentMain"; // 로그인 한 사용자를 위한 첫 페이지 URL
	  }
}
