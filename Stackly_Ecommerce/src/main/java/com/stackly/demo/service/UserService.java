package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

import com.stackly.demo.dto.UserDto;

public interface UserService 
{
	ResponseEntity<?> registerUser(UserDto dto);
	
	ResponseEntity<?> getAllUsers();
	
	ResponseEntity<?> getUserById(Long id);
	
	ResponseEntity<?> deleteUser(Long id);

}
