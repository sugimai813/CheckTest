package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@GetMapping("/user/home")
	public String home(Model model) {
		return "user/home";
	}
	
	@PostMapping("/user/list")
	public String list(Model model) {
		return "user/list";
	}
	
	@PostMapping("/user/add")
	public String add(Model model) {
		return "user/add";
	}
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<UserEntity> userlist = userService .searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}
}
