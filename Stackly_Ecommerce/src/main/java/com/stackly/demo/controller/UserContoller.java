package com.stackly.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.dto.UserDto;
import com.stackly.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserContoller 
{
	private final UserService userService;
	
	public UserContoller(UserService userService) 
	{
		this.userService = userService;
	}
	
	//Post
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserDto dto)
	{
		return userService.registerUser(dto);
	}
	
	

}
