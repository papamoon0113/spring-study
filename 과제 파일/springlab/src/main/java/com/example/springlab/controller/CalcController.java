package com.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
	@RequestMapping("/calc")
	public ModelAndView calc(int firstNum, String operator, int secondNum){
		ModelAndView mac = new ModelAndView();
		switch (operator){
			case "plus":
				mac.addObject("result", firstNum + secondNum);
				break;
			case "minus":
				mac.addObject("result", firstNum - secondNum);
				break;
			case "multiply":
				mac.addObject("result", firstNum * secondNum);
				break;
			case "divide":
				if (secondNum == 0){
					mac.addObject("errorMessage", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!");
					mac.setViewName("errorResult");
					return mac;
				}
				mac.addObject("result", firstNum / secondNum);
				break;
		}

		mac.setViewName("calcResult");
		return mac;
	}
}
