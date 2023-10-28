package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRequest implements Serializable{
	
	@NotEmpty(message = "姓は必須入力項目です")
	private String lastname;
	
	@NotEmpty(message = "名は必須入力項目です")
	private String firstname;
	
	@NotNull(message = "郵便番号は必須入力項目です")
	@Digits(integer = 7, fraction = 0, message = "7桁の数字を入力してください")
	private Integer postnumber;
	
	@NotEmpty(message = "住所は必須入力項目です")
	@Size(max = 150, message = "150文字以内で入力してください")
	private String address;
	
	@Min(value = 0, message = "電話番号は数字を入力してください")
	private Integer phone;
	
	@Size(max = 50, message = "50文字以内で入力してください")
	private String remarks;
}