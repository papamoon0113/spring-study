package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(Model model){
		System.out.println("Hello Controller 실행");
		model.addAttribute("data", "spring boot");
		return "helloView";
	}
}
