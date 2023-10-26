package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "addressbook")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "postnumber")
	private Integer postnumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private Integer phone;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "updatedate")
	private Date updatedate;
}
