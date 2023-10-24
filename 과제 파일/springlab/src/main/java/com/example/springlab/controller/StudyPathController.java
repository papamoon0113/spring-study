package com.example.springlab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public class StudyPathController {

	@GetMapping("/study/{number}/thymeleaf")
	public ModelAndView redirect(@PathVariable("number") int number){
		ModelAndView mav = new ModelAndView();
		switch (number){
			case 1:
				mav.setViewName("redirect:/https://abbo.tistory.com/56");
				break;
			case 2:
				mav.setViewName("redirect:/https://abbo.tistory.com/57");
				break;
			case 3:
				mav.setViewName("redirect:/https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html");
				break;
			case 4:
				mav.setViewName("redirect:/https://www.baeldung.com/dates-in-thymeleaf");
				break;
		}
		return mav;
	}
}
