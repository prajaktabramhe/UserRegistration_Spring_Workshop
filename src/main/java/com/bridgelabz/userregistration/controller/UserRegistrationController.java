package com.bridgelabz.userregistration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.dto.UserRegistraionDTO;
import com.bridgelabz.userregistration.model.UserRegistartionData;
import com.bridgelabz.userregistration.service.IUserRegistrationService;

@RestController
@RequestMapping("/userregistration")
public class UserRegistrationController 
{
	@Autowired
	private IUserRegistrationService userRegistartionService;
	
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getUserData()
	{
		List<UserRegistartionData> userList=null;
		userList = userRegistartionService.getUserData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success",userList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createUserData(@Valid @RequestBody UserRegistraionDTO userregistraionDTO){
		UserRegistartionData userData = userRegistartionService.createUserData(userregistraionDTO);
		ResponseDTO responseDTO = new ResponseDTO("New User Added", userData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateUserData(@Valid @PathVariable("id") int id,@RequestBody UserRegistraionDTO userregistraionDTO){
		UserRegistartionData updateUserData =null;
		updateUserData = userRegistartionService.updateUserData(id,userregistraionDTO);
		ResponseDTO responseDTO = new ResponseDTO("User Updated", updateUserData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteUserData(@PathVariable int id){
		userRegistartionService.deleteUserData(id);
		ResponseDTO responseDTO = new ResponseDTO("User Updated", "User With Id: "+id+" Deleted!");
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
}
