package com.path.demo.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
// POJO CLASS
@Data
@NoArgsConstructor  // It's empty constructor
@AllArgsConstructor // It's constructor with all field
public class Student {
	
	@NotNull(message="Id should not be null")
	private Integer id;
	
	@NotBlank(message="name connot be emmpty")
	private String name;
	
	@NotBlank(message="course cannot be empty")
	private String course;
	
	@Min(value=18, message="Agemust be grater than 18")
	private Integer age;
	 
}
