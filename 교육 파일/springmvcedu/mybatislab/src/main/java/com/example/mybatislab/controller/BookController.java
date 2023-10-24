package com.example.mybatislab.controller;

import com.example.mybatislab.dao.BookMapper;
import com.example.mybatislab.domain.BookDTO;

import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class BookController {
	@Autowired
	BookMapper dao;

	private HashMap<String, String> createMenu(){
		HashMap<String, String> menu = new HashMap<>();
		menu.put("전체 도서 리스트 보기", "/book");
		menu.put("가격이 높은 순으로 도서 리스트 보기", "/bookOrderByPrice");
		menu.put("가격이 20000원 이상인 도서 리스트 보기", "/bookUpper?n=20000");
		menu.put("웹 프로그래밍 도서 리스트 보기", "/bookOfWebProgramming");
		menu.put("데이터베이스와 인프라 도서 리스트 보기", "/bookOfDataBaseAndInfra");
		menu.put("도서명에 '자바'가 포함된 도서 리스트 보기", "/bookIncludedJava");
		menu.put("분류별 도서 가격의 평균 보기", "/averagePriceOfKind");
		return menu;
	}
	@GetMapping("/book/main")
	public ModelAndView viewMain(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu", createMenu());
		mav.setViewName("bookPage");
		return mav;
	}
	@GetMapping("/book")
	public ModelAndView readBook(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", dao.readBook());
		mav.addObject("menu", createMenu());
		mav.setViewName("bookPage");
		return mav;
	}

	@GetMapping("/bookOrderByPrice")
	public ModelAndView readBookOrderByPrice(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", dao.readBookOrderByPrice());
		mav.setViewName("bookPage");
		mav.addObject("menu", createMenu());
		return mav;
	}

	@GetMapping("/bookUpper")
	public ModelAndView readBookUpper(int n){
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", dao.readBookUpper(n));
		mav.setViewName("bookPage");
		mav.addObject("menu", createMenu());
		return mav;
	}

	@GetMapping("/bookOfWebProgramming")
	public ModelAndView readBookOfWebProgramming(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", dao.readBookOfWebProgramming());
		mav.setViewName("bookPage");
		mav.addObject("menu", createMenu());

		return mav;
	}

	@GetMapping("/bookOfDataBaseAndInfra")
	public ModelAndView readBookOfDataBaseAndInfra(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", dao.readBookOfDataBaseAndInfra());
		mav.addObject("menu", createMenu());
		mav.setViewName("bookPage");
		return mav;
	}

	@GetMapping("/bookIncludedJava")
	public ModelAndView readBookIncludedJava(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", dao.readBookIncludedJava());
		mav.addObject("menu", createMenu());
		mav.setViewName("bookPage");
		return mav;
	}

	@GetMapping("/averagePriceOfKind")
	public ModelAndView readAveragePriceOfKind(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("response", dao.readAveragePriceOfKind());
		mav.addObject("menu", createMenu());
		mav.setViewName("bookPage");
		return mav;
	}

	@PostMapping("/book")
	public ModelAndView createBook(BookDTO dto){
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", dao.createBook(dto));
		mav.addObject("menu", createMenu());
		mav.addObject("response", dao.readBook());
		mav.setViewName("bookPage");
		return mav;
	}
}
