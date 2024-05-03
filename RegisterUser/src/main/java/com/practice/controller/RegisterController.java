package com.practice.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.daos.UserDao;
import com.practice.entity.User;
 
@Controller
public class RegisterController {

	@RequestMapping("/")
	public String home() {
		System.out.println("This is home URL");
		return "index";
	}
	
	@RequestMapping("/submit")
    public String save(@RequestParam("id") Integer id,@RequestParam("firstname") String firstname,
    		@RequestParam("lastname") String lastname,@RequestParam("email") String email,
    		@RequestParam("password") String password) 
	{
		
		
		User u = new User(id,firstname , lastname,email, password);
		System.out.println(u);
		try{
			UserDao uDao= new UserDao();
			System.out.println(uDao.save(u));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
    }
	
	
}


