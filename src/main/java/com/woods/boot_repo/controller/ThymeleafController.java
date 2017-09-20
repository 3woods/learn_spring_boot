package com.woods.boot_repo.controller;
/**
 * Thymeleaf for Spring Boot
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.woods.boot_repo.combo.Greeting;
import com.woods.boot_repo.combo.TestVO;
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
		model.addAttribute("greeting", new Greeting());//注意：变量名必须是类名的首字线小写格式
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting) {//注意：参数名必须是类名的首字线小写格式
		return "result";
	}
	@GetMapping("/testvo")
	public String testForm(Model model) {
		model.addAttribute("testVO", new TestVO());//注意：变量名必须是类名的首字线小写格式
		return "testvo";
	}

//	@PostMapping("/testvo")
//	public String testFormSubmit(@ModelAttribute TestVO testVO) {//注意：参数名必须是类名的首字线小写格式
//		return "testformresult";
//	}
	@PostMapping("/testvo")
	public String submit(@ModelAttribute TestVO abc, Model model) {//另一种写法
		model.addAttribute("abc", abc);
		return "testformresult";
	}
}