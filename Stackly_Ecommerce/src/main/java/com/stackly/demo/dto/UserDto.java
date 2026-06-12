package com.stackly.demo.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto
{
	private Long userId;
	
	@NotBlank(message="Name required")
	private String userName;
	
	@NotNull(message="Password required")
	private Long userPass;
	
	@Email(message="Invalid Email")
	private String email;
	
	@NotNull(message="Phone number required")
	private Long phoneNumber;
	
	private List<AddressDto> address;



}
