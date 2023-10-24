package com.example.springlab.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduControllerAnswer {
	@RequestMapping(value = "/getScore2")
	public ModelAndView get_score(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		int avgScore = Integer.parseInt(req.getParameter("avgScore"));
		mav.addObject("name", req.getParameter("name"));
		mav.addObject("refinfo", req.getHeader("referer"));
		if(avgScore < 70){
			mav.setViewName("gradeD");
		}else if(avgScore < 80){
			mav.setViewName("gradeC");
		}else if(avgScore < 90){
			mav.setViewName("gradeB");
		}else{
			mav.setViewName("gradeA");
		}
		return mav;
	}
}
