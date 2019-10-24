package net.skhu.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class TaController {

	@RequestMapping("ta/index")
	public String index() {
		return "ta/index"; // 로그인 한 ta를 위한 첫 페이지 URL
	}
}
