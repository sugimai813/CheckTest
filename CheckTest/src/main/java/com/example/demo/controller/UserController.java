package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@Controller
public class UserController {

//	ホーム画面の表示
	@GetMapping("/user/home")
	public String home(Model model) {
		return "user/home";
	}
	
//	一覧画面の表示
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
	
//	詳細画面の表示
	@GetMapping("/user/{id}/view")
	public String displayview(@PathVariable Integer id, Model model) {
		UserEntity user = userService.findById(id);
		model.addAttribute("userData", user);
		return "user/view";
	}
	
//	新規登録画面
	@GetMapping("/user/add")
	public String displayadd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "user/add";
	}
	
	@PostMapping("/user/create")
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if(result.hasErrors()) {
		List<String> erroList = new ArrayList<String>();
		for(ObjectError error : result.getAllErrors()) {
			erroList.add(error.getDefaultMessage());
		}
		model.addAttribute("validationError", erroList);
		return "user/add";
		}
		
		userService.create(userRequest);
		return "redirect:/user/list";
	}
	
//	情報編集
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable Integer id, Model model) {
		UserEntity user = userService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(id); 
		userUpdateRequest.setLastname(user.getLastname());
		userUpdateRequest.setFirstname(user.getFirstname());
		userUpdateRequest.setPostnumber(user.getPostnumber());
		userUpdateRequest.setAddress(user.getAddress());
		userUpdateRequest.setPhone(user.getPhone());
		userUpdateRequest.setRemarks(user.getRemarks());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "user/edit";
	}
	
	@PostMapping("/user/update")
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<String> erroList = new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				erroList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", erroList);
			model.addAttribute("userUpdateRequest", userUpdateRequest);
			return "user/edit";
		}
		userService.update(userUpdateRequest);
		return "redirect:/user/list";
	}
	
//	情報削除
	@GetMapping("/user/{id}/delete")
	public String delete(@PathVariable Integer id, Model model) {
		userService.delete(id);
		return "redirect:/user/list";
	}
}
