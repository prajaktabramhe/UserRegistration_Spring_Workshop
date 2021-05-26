package com.bridgelabz.userregistration.exception;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bridgelabz.userregistration.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class UserRegistrationExceptionHandler 
{
	private static final String message = "Exception while processing request";

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpNotReadableException(HttpMessageNotReadableException exception){

		log.error("Invalid Date Format" , exception);
		ResponseDTO responseDTO = new ResponseDTO(message , "Date should be of the format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodNotValidArgumentException(MethodArgumentNotValidException exception)
	{
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMsg = errorList.stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO response = new ResponseDTO("Exception For Invalid Arguments", errorMsg);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(UserRegistrationException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(UserRegistrationException exception)
	{
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	
}
