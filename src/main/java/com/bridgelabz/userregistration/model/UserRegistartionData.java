package com.bridgelabz.userregistration.model;



import java.time.LocalTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.bridgelabz.userregistration.dto.UserRegistraionDTO;

import lombok.Data;

@Entity
@Table(name = "users")
public @Data class UserRegistartionData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int ID;
	private String firstName;
	private String lastName;
	private int age;
	private Long mobileNumber;
	private LocalTime registrationTime;
	
	public UserRegistartionData ()
	{}

	public UserRegistartionData(UserRegistraionDTO userregistraionDTO) 
	{
		this.updateUserData(userregistraionDTO);
		this.registrationTime = LocalTime.now();
		
	}

	public void updateUserData(UserRegistraionDTO userregistraionDTO)
	{
		this.firstName = userregistraionDTO.getFirstName();
		this.lastName = userregistraionDTO.getLastName();
		this.mobileNumber = userregistraionDTO.getMobileNumber();
		this.age = userregistraionDTO.getAge();
		
	}
}
