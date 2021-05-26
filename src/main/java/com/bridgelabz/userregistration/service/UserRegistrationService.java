package com.bridgelabz.userregistration.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.userregistration.dto.UserRegistraionDTO;
import com.bridgelabz.userregistration.model.UserRegistartionData;
import com.bridgelabz.userregistration.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService implements IUserRegistrationService {

	@Autowired
	public UserRegistrationRepository userRegistrationRepository;
	
	@Override
	public List<UserRegistartionData> getUserData() 
	{
		return userRegistrationRepository.findAll();
	}
	
	@Override
	public UserRegistartionData createUserData(UserRegistraionDTO userregistraionDTO) {
		UserRegistartionData userData = new UserRegistartionData(userregistraionDTO);
		return userRegistrationRepository.save(userData);
	}

	@Override
	public UserRegistartionData updateUserData(int id, UserRegistraionDTO userregistraionDTO) {
		UserRegistartionData userData = userRegistrationRepository.getById(id);
		userData.updateUserData(userregistraionDTO);
		return userRegistrationRepository.save(userData);
	}


	@Override
	public void deleteUserData(int id) {
		userRegistrationRepository.deleteById(id);
		
	}

}
