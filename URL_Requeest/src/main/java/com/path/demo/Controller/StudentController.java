package com.path.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.path.demo.Model.Student;
import com.path.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@Validated
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/students")
	public List<Student> getallstudent()
	{
		return studentservice.getallstudent();
	}
	
	@GetMapping("/students/{id}")
	public Student getstudentbyid(@PathVariable int id)  //Used Extract ID from URL
	{
		return studentservice.getstudentbyid(id);
	}
	//ADD
	@PostMapping("/students")  //Used for inserting new data
	public Student savestudent(@Valid @RequestBody Student student) 
	{ //@Valid-> It activates: Validation annotations. like: NotNull,NotBlank,Min.
	  //@RequestBody-> It converts JSON to Java  Object
		return studentservice.addstudent(student);
	}
	
	//UPDATE
	@PutMapping("/students/{id}") // USed for Full update
	public String updatestudent(@PathVariable int id, @Valid @RequestBody Student student) 
	{
		return studentservice.updatestudent(id,student);
	}
	
	@DeleteMapping("/students/{id}")
	public String deletestudent(@PathVariable int id) {
		return studentservice.deletestudent(id);
	}
	
	@PatchMapping("/students/{id}")
	public String patchstudent(@PathVariable int id, @RequestBody Student student) {
		return studentservice.patchstudent(id,student);
	}

}
