package com.example.springedu.controller;

import com.example.springedu.domain.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/postman")
public class PostmanTestController {
	@GetMapping("/dtotest")
	public ResponseEntity<?> getMemberTemp(HttpServletRequest req){

		return ResponseEntity.ok().body(MemberDTO.builder().name("테스트").phone("010-0000-0000").id("test_id").password("test_password").build());
	}
}
