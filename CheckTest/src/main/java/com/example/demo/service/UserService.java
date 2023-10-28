package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserEntity> searchAll(){
		return userRepository.findAll();
	}
	
	public UserEntity findById(Integer id) {
		return userRepository.getOne(id);
	}

//	新規登録
	public void create(UserRequest userRequest) {
		LocalDate now = LocalDate.now();
		UserEntity user = new UserEntity();
		user.setLastname(userRequest.getLastname());
		user.setFirstname(userRequest.getFirstname());
		user.setPostnumber(userRequest.getPostnumber());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setRemarks(userRequest.getRemarks());
		user.setUpdatedate(now);
		userRepository.save(user);
	}
	
//	情報更新
	public void update(UserUpdateRequest userUpdateRequest) {
		UserEntity user = findById(userUpdateRequest.getId());
		user.setLastname(userUpdateRequest.getLastname());
		user.setFirstname(userUpdateRequest.getFirstname());
		user.setPostnumber(userUpdateRequest.getPostnumber());
		user.setAddress(userUpdateRequest.getAddress());
		user.setPhone(userUpdateRequest.getPhone());
		user.setRemarks(userUpdateRequest.getRemarks());
		user.setUpdatedate(LocalDate.now());
		userRepository.save(user);
	}
	
//	情報削除
	public void delete(Integer id) {
		UserEntity user = findById(id);
		userRepository.delete(user);
	}
}
