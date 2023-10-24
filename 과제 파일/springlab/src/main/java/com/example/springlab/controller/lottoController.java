package com.example.springlab.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Random;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.example.springedu.domain.LottoDTO;

@Controller
@SessionAttributes("lottoCount")
public class lottoController {

	@ModelAttribute("lottoCount")
	public int[] getCountLotto() {
		System.out.println("lottoCount 생성");
		int[] count = {0};
		return count;
	}

	@GetMapping("/lotto")
	public ModelAndView runLotto(@ModelAttribute("dto") LottoDTO dto,
									@ModelAttribute("lottoCount") int[] lottoCount,
									SessionStatus sessionStatus,
									HttpServletRequest req){
		System.out.println("lottoNum : " + dto.getLottoNum() + "\nresult : " + dto.getResult() + "\nimgName : " + dto.getImgName());

		ModelAndView mac = new ModelAndView();
		Random random = new Random();
		if (dto.getLottoNum() == (random.nextInt(6)+1)){
			dto.setImgName("/images/sun.png");
			dto.setResult("success");
		}
		else {
			if (lottoCount[0]++ < 3){
				dto.setImgName("/images/rain.png");
				dto.setResult("fail");
			}
			else {
				dto.setImgName("/images/snow.png");
				dto.setResult("over");
				sessionStatus.setComplete();
			}
		}
		mac.addObject("reqinfo", req.getHeader("referer"));
		//DTO 안 보내도 req가 들고 있음
		mac.setViewName("lottoView");

		System.out.println("lottoNum : " + dto.getLottoNum() + "\nresult : " + dto.getResult() + "\nimgName : " + dto.getImgName());
		return mac;
	}
}
