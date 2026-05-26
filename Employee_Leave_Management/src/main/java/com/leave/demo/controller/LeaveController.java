package com.leave.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leave.demo.model.EmployeeLeave;
import com.leave.demo.service.LeaveService;

import jakarta.validation.Valid;

@RestController
@Validated
public class LeaveController {

    @Autowired
    LeaveService leaveService;


    @GetMapping("/leaves")
    public List<EmployeeLeave> getAllLeaves() 
    {
    	return leaveService.getAllLeaves();
    }


    @GetMapping("/leaves/{id}")
    public EmployeeLeave getLeaveById(@PathVariable int id) 
    {
        return leaveService.getLeaveById(id);
    }


    @PostMapping("/leaves")
    public EmployeeLeave addLeave(@Valid @RequestBody EmployeeLeave leave) 
    {
        return leaveService.addLeave(leave);
    }

    
    @PutMapping("/leaves/{id}")
    public String updateLeave(@PathVariable int id,@Valid @RequestBody EmployeeLeave leave) 
    {
    	return leaveService.updateLeave(
                id, leave);
    }


    @DeleteMapping("/leaves/{id}")
    public String deleteLeave(@PathVariable int id) 
    {
        return leaveService.deleteLeave(id);
    }
}
