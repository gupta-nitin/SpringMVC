package com.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmisionController {
	@InitBinder
	public void initDataBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields(new String[] { "studentMobile" });
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy**MM**dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat,false));
		webDataBinder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());
	}

	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView createAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}

	@ModelAttribute
	public void addHeader(Model model1) {
		model1.addAttribute("headermsg", "Spring MVC local");
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmission(@Valid @ModelAttribute("stud") Student student1, BindingResult bindingResult) {
		ModelAndView modelAndView;
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("AdmissionForm");
			return modelAndView;
		}
		modelAndView = new ModelAndView("AdmissionSuccess");
		return modelAndView;
	}

	// With @ModelAttribute annotation on parameters
	// @RequestMapping(value = "/submitAdmissionForm.html",
	// method=RequestMethod.POST)
	// public ModelAndView submitAdmission(@ModelAttribute("stud") Student student1)
	// {
	// ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
	// modelAndView.addObject("headermsg", "Congratulation
	// "+student1.getStudentName());
	// return modelAndView;
	// }
	// With out model Attibute anotation
	// @RequestMapping(value = "/submitAdmissionForm.html",
	// method=RequestMethod.POST)
	// public ModelAndView submitAdmission(@RequestParam("studentName") String
	// StudentName, @RequestParam("hobby") String hobby) {
	// ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
	// Student student1= new Student();
	// student1.setStudentHobby(hobby);
	// student1.setStudentName(StudentName);
	// modelAndView.addObject("headermsg", "Congratulation "+StudentName);
	// modelAndView.addObject("stud",student1);
	// return modelAndView;
	// }

	// How to assign default value if form field is submitted with no value
	// @RequestMapping("/submitAdmissionForm.html")
	// public ModelAndView submitAdmission(@RequestParam(value="studentName"
	// ,defaultValue="mr xyz") String sName) {
	//
	// ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
	// modelAndView.addObject("msg", "Your name is " +sName);
	// return modelAndView;
	// }

	// How to us map of request parameters
	// @RequestMapping("/submitAdmissionForm.html")
	// public ModelAndView submitAdmission(@RequestParam Map<String, String> reqVar)
	// {
	//
	// ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
	// modelAndView.addObject("msg", "Your name is " +reqVar.get("studentName"));
	// return modelAndView;
	// }

}
