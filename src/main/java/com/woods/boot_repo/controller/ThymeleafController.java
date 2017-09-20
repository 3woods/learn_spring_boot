package com.woods.boot_repo.controller;
/**
 * Thymeleaf for Spring Boot
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.woods.boot_repo.entity.TestVO;
import com.woods.boot_repo.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	
    @RequestMapping("/hi")
	public String hello(Locale locale, Model model) {
		model.addAttribute("greeting", "Hello!");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);
		return "hello";
	}
	@GetMapping("/greeting")
	public String greetingForm(Model model) {
    	TestVO testVO=new TestVO();
    	testVO.setName("张三丰");
		model.addAttribute("greeting", testVO);
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute TestVO greeting) {
		return "result";
	}
}