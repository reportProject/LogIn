package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaController {

	@RequestMapping("ta/index")
    public String index() {
        return "ta/index"; //로그인한 ta 사용자를 위한 첫 페이지 URL
    }
}
