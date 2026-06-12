package com.stackly.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{

}
