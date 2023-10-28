package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserUpdateRequest extends UserRequest implements Serializable{
	
	@NotNull
	private Integer id;
}