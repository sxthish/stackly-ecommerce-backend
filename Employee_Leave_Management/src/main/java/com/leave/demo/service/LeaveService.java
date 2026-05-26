package com.leave.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leave.demo.model.EmployeeLeave;

@Service
public class LeaveService {

    List<EmployeeLeave> leaveList =
            new ArrayList<>(Arrays.asList(
            		new EmployeeLeave(101,"Sathish","Sick Leave", 2,"Fever"),
            		new EmployeeLeave(102, "Sai","Casual Leave",1, "Personal Work")
            ));


    public List<EmployeeLeave> getAllLeaves() 
    {
        return leaveList;
    }


    public EmployeeLeave getLeaveById(int id) 
    {
        for (EmployeeLeave e : leaveList) 
        {
            if (e.getEmployeeId() == id) 
            {
                return e;
            }
        }
        return null;
    }


    public EmployeeLeave addLeave(EmployeeLeave leave) 
    {
        leaveList.add(leave);
        return leave;
    }


    public String updateLeave(int id, EmployeeLeave leave) 
    {
        for (EmployeeLeave e : leaveList) 
        {
            if (e.getEmployeeId() == id) 
            {
                e.setEmployeeName(leave.getEmployeeName());
                e.setLeaveType(leave.getLeaveType());
                e.setNumberOfDays(leave.getNumberOfDays());
                e.setReason(leave.getReason());

                return "Leave Updated Successfully";
            }
        }
        return "Employee Not Found";
    }

    
    public String deleteLeave(int id) 
    {
        for (EmployeeLeave e : leaveList) 
        {
            if (e.getEmployeeId() == id) 
            {
                leaveList.remove(e);
                return "Leave Deleted Successfully";
            }
        }
        return "Employee Not Found";
    }
}
