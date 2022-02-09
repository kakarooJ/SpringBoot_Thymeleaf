package com.example.testthymeleaf.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.testthymeleaf.person.Person;

@Controller	//@RestController 로 할 경우 return "index"; 로 처리하면 index.html로 인식하지 못하고, index 텍스트만 출력하게 된다.
public class MyController {
	
	@RequestMapping("/")
	public ModelAndView get() { 
		ModelAndView modelAndView = new ModelAndView();
		Person person = new Person(12, "Lee");

		ArrayList<String[]> data1 = new ArrayList<String[]>();
		data1.add(new String[] {"park","park@aaaa"});
		data1.add(new String[] {"kim","kim@bbbb"});
		data1.add(new String[] {"lee","lee@cccc"});
		
		//spring.thymeleaf.suffix=.html 로 지정해 놨기 때문에 index.html을 찾는다
		modelAndView.setViewName("index");
		modelAndView.addObject("myPerson", person);
		modelAndView.addObject("myData", data1);
		
		return modelAndView;
	}
	
	 
	/*
	@RequestMapping("/")
	public String get() {
        return "index";		//spring.thymeleaf.suffix=.html 로 지정해 놨기 때문에 index.html을 찾는다
	}*/
}
