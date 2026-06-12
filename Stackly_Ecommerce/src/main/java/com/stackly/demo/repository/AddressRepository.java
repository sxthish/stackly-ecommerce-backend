package com.stackly.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.demo.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long>
{


}
