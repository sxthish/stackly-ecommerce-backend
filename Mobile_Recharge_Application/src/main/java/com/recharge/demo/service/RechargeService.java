package com.recharge.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.recharge.demo.model.Recharge;

@Service
public class RechargeService {

    List<Recharge> rechargeList =
            new ArrayList<>(Arrays.asList(
            		new Recharge(101,"9876543210","Jio", 299,"PREPAID",  "SUCCESS", 20.0, false),
            		new Recharge(102, "9123456789","Airtel",699,"POSTPAID","SUCCESS", 100.0,true)
            		));


    public List<Recharge> getAllRecharge() 
    {
    	return rechargeList;
    }


    public Recharge getRechargeById(int id) 
    {
        for (Recharge r : rechargeList) 
        {
            if (r.getRechargeId() == id) 
            {
                return r;
            }
        }
        return null;
    }


    public Recharge addRecharge(Recharge recharge) 
    {
        if (!(recharge.getPlanType().equalsIgnoreCase("PREPAID")||recharge.getPlanType().equalsIgnoreCase("POSTPAID"))) 
        {
            throw new RuntimeException("Invalid Plan Type");
        }

        recharge.setStatus("SUCCESS");

        if (recharge.getAmount() >= 500) 
        {
            recharge.setCashback(50.0);
            recharge.setPremiumPlan(true);
        } else {
            recharge.setCashback(10.0);
            recharge.setPremiumPlan(false);
        }

        rechargeList.add(recharge);
        return recharge;
    }


    public String updateRecharge(int id, Recharge recharge) 
    {
        for (Recharge r : rechargeList) 
        {
            if (r.getRechargeId() == id) 
            {
                r.setMobileNumber(recharge.getMobileNumber());
                r.setOperator(recharge.getOperator());
                r.setAmount(recharge.getAmount());
                r.setPlanType(recharge.getPlanType());

                return "Recharge Updated Successfully";
            }
        }
        return "Recharge Not Found";
    }


    public String deleteRecharge(int id) 
    {
        for (Recharge r : rechargeList) 
        {
            if (r.getRechargeId() == id) 
            {
                rechargeList.remove(r);
                return "Recharge Deleted Successfully";
            }
        }
        return "Recharge Not Found";
    }
}