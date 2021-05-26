package com.bridgelabz.userregistration.service;

import java.util.List;


import com.bridgelabz.userregistration.dto.UserRegistraionDTO;
import com.bridgelabz.userregistration.model.UserRegistartionData;

public interface IUserRegistrationService {

	List<UserRegistartionData> getUserData();

	UserRegistartionData createUserData(UserRegistraionDTO userregistraionDTO);
	
	UserRegistartionData updateUserData(int id, UserRegistraionDTO userregistraionDTO);

	void deleteUserData(int id);

	
}
