package com.ssafy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/board")
	public String board() {
		return "/board/dashboard";
	}
	
	@GetMapping("/location")
	public String location() {
		return "/geolocation_dr";
	}
}
