package com.path.demo.service;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.path.demo.Model.Student;

import jakarta.validation.Valid;

@Service
public class StudentService {

	List<Student> stList = new ArrayList<>(Arrays.asList(
			new Student(101,"Sathihsh","java",22),
			new Student(102,"Sai","Python",12)
			));
	public String updatestudent;

	public List<Student> getallstudent() {
		return stList;
	}

	public Student getstudentbyid(int id) {
		for(Student s:stList) {
			if(s.getId()==id) {
			return s;
		}
	}
			return null;
		}

	public Student addstudent(@Valid Student student) 
	{
		stList.add(student);
		return student;
	}

	public String updatestudent(int id, @Valid Student student) 
	{
		for(Student s:stList) {
			if(s.getId()==id) {
				s.setId(student.getId());
				s.setName(student.getName());
				s.setCourse(student.getCourse());
				s.setAge(student.getAge());
				
				return "Student details Updated successfully";
			}
		}
		return "Student Not found";
	}

	public String deletestudent(int id) {
		for(Student s:stList) {
			if(s.getId()==id) {
				stList.remove(s);
			}
		return "Records Deleted";
	}
	return "record not found";
	}

	public String patchstudent(int id, Student student) 
	{
		for(Student s:stList) {
			if(s.getId()==id) {
				if(student.getName()!=null) {
					s.setName(student.getName());
				}
				if(student.getCourse()!=null) {
					s.setCourse(student.getCourse());
				}
				if(student.getAge()!=null) {
					s.setAge(student.getAge());
				}
				return "Student details updated";
		 }
		}
		return "Student not found";
	}
}


