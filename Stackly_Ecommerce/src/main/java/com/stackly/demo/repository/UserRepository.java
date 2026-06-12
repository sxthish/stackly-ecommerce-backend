package com.stackly.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Long>
{

}
