package com.app.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Entity.Employee;

@Controller
public class EmpController {
	
	
	HashSet<Employee> list = new HashSet<Employee>();

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/empform")
	public ModelAndView showform() {
		
		return new ModelAndView("empform", "", new Employee());
	}
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute("emp") Employee emp ) {
		
		System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());
		list.add(new Employee(emp.getId(),emp.getName(),emp.getSalary(),emp.getDesignation()));
		
		return new ModelAndView("redirect:/viewemp");
		
		
	}
	
	@RequestMapping("/viewemp")
	public ModelAndView viewEmp() {
		
		return new ModelAndView("viewemp","list", list);
		
	}
	
}
