package com.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("greet")
public class HelloController  {

	@RequestMapping("/welcome")
	public ModelAndView abc() {
		ModelAndView modelAndView = new ModelAndView("Hello");
		modelAndView.addObject("WelcomeMessage", "Welcome Message from spring");
		return modelAndView;
	}

	@RequestMapping("hi/{userName}")
	public ModelAndView greetHello(@PathVariable Map<String,String> pathVar){
		ModelAndView modelAndView = new ModelAndView("Hello");
		modelAndView.addObject("hi", "Hi "+pathVar.get("userName")+" from spring MVC");
		return modelAndView;
	}
}
