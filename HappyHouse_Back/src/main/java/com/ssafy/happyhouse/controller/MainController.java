package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/aptlist")
	public String aptList() {
		return "apt/aptlist";
	}
}
 