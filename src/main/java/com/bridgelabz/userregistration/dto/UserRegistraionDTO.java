package com.bridgelabz.userregistration.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class UserRegistraionDTO 
{
	@NotBlank(message = "First name cannot be blank")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be blank")
	private String lastName;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	private LocalDate dateOfBirth;
	
	@NotNull(message = "Age cannot be null")
	private int age;
	
	@NotNull(message = "MobileNumber cannot be null")
	private Long mobileNumber;

	public UserRegistraionDTO () {} 
	
	public UserRegistraionDTO(String firstName,String lastName,LocalDate dateOfBirth,Long mobileNumber,int age)
	{
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.age = age;
	this.mobileNumber = mobileNumber;

	}
}
