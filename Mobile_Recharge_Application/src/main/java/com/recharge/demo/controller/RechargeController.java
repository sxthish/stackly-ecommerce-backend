package com.recharge.demo.controller;

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

import com.recharge.demo.model.Recharge;

import com.recharge.demo.service.RechargeService;

import jakarta.validation.Valid;

@RestController
@Validated
public class RechargeController {

    @Autowired
    RechargeService rechargeService;


    @GetMapping("/recharges")
    public List<Recharge> getAllRecharge() 
    {
    	return rechargeService.getAllRecharge();
    }


    @GetMapping("/recharges/{id}")
    public Recharge getRechargeById(@PathVariable int id) 
    {
    	return rechargeService.getRechargeById(id);
    }


    @PostMapping("/recharges")
    public Recharge addRecharge(@Valid @RequestBody Recharge recharge) 
    {
    	return rechargeService.addRecharge(recharge);
    }


    @PutMapping("/recharges/{id}")
    public String updateRecharge(@PathVariable int id, @Valid @RequestBody Recharge recharge) 
    {
        return rechargeService.updateRecharge(id,recharge);
    }


    @DeleteMapping("/recharges/{id}")
    public String deleteRecharge(@PathVariable int id) 
    {
        return rechargeService.deleteRecharge(id);
    }
}