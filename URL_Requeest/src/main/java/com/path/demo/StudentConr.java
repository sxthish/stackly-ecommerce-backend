//package com.path.demo;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class StudentConr {
//	
//	@GetMapping("/welcome")
//	
//	public String welcomeStd(@RequestParam String name) {
//		return "Welcome " + name;
//	}
//	
//	@GetMapping("/employee")
//	
//	public String employeedetails(@RequestParam String name, @RequestParam int id,@RequestParam String dept) {
//		return name+" "+id+" "+dept;
//	}
//	
//	@GetMapping("/course")
//	public String coursedetails(@RequestParam (defaultValue = "JAVA") String cname) {
//		return cname;
//	}
//	
//	@GetMapping("/student/{id}")
//	public int geetStudent(@PathVariable int id) {
//		return id;
//	}
//	
//	@GetMapping("/product/{pid}/{pname}")
//	public String productdetails(@PathVariable int pid,@PathVariable String pname) {
//		return "ProductId: "+pid+" ProductName: "+pname;
//	}
//
//}
