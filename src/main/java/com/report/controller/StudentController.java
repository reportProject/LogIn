package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("student/index")
    public String index() {
        return "student/index"; //로그인한 student 사용자를 위한 첫 페이지 URL
    }
	
	
}
