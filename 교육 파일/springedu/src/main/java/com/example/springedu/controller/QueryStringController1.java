package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QueryStringController1 {

	@RequestMapping("/querystring1")
	public ModelAndView proc(String name) { // 기본적으로 ?name = dddd 라는 식으로 입력될 거라고 인식함
		ModelAndView mav = new ModelAndView();
		System.out.println("[" + name + "]");
		mav.addObject("spring", name);
		mav.setViewName("queryView1");
		return mav;
	}

	@RequestMapping("/querystring2")
	public ModelAndView proc(int number) {
		// 숫자는 null을 받을 수 없음
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", number);
		mav.setViewName("queryView1");
		return mav;
	}

	@RequestMapping("/querystring3")
	public ModelAndView proc(String name,
		@RequestParam("num") int number) {// ? value가 파라미터 이름이 됨
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name + ":" + number);
		mav.setViewName("queryView1");
		return mav;
	}

	@RequestMapping("/querystring4")
	public ModelAndView proc(
		@RequestParam("myname1") String name1,
		@RequestParam(value = "myname2", required = false) String name2,
		@RequestParam(defaultValue = "10") int number1,
		@RequestParam(value = "NUM2", defaultValue = "100") int number2) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name1 + ":" + (number1 + number2)
			+ ":" + name2);
		mav.setViewName("queryView1");
		return mav;
	}
}






