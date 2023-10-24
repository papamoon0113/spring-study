package com.example.springlab.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
	@RequestMapping(value = "/educontroller")
   public ModelAndView select_grade(int avgScore, HttpServletRequest req){
	   ModelAndView modelAndView= new  ModelAndView();
	   String name = req.getParameter("name");
	   modelAndView.addObject("refinfo", req.getHeader("referer"));

	   modelAndView.addObject("name", name);
	   if(avgScore < 70){
		   modelAndView.setViewName("gradeD");
	   }
	   else if (avgScore < 80){
		   modelAndView.setViewName("gradeC");
	   } else if (avgScore < 90) {
		   modelAndView.setViewName("gradeB");
	   }
	   else {
		   modelAndView.setViewName("gradeA");
	   }
	   return modelAndView;
   }
}
