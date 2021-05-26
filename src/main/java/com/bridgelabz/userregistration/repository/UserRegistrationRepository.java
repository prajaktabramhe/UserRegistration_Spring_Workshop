package com.bridgelabz.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.userregistration.model.UserRegistartionData;

public interface UserRegistrationRepository extends JpaRepository<UserRegistartionData, Integer> 
{

}
