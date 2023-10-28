package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRequest implements Serializable{
	
	@NotEmpty(message = "姓は必須入力項目です")
	private String lastname;
	
	@NotEmpty(message = "名は必須入力項目です")
	private String firstname;
	
	@NotNull(message = "郵便番号は必須入力項目です")
	@Min(value = 1000000, message = "7桁の郵便番号で入力してください")
    @Max(value = 9999999, message = "7桁の郵便番号で入力してください")
	private Integer postnumber;
	
	@NotEmpty(message = "住所は必須入力項目です")
	@Size(max = 150, message = "住所は150文字以内で入力してください")
	private String address;
	
	@Pattern(regexp = "^[0-9]*$", message = "電話番号は数字を入力してください")
	private String phone;
	
	@Size(max = 50, message = "備考は50文字以内で入力してください")
	private String remarks;
}