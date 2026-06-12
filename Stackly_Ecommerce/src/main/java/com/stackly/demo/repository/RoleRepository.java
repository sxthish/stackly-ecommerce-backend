package com.stackly.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackly.demo.entity.Role;
import com.stackly.demo.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role,Long>
{
	Optional<Role> findByRoleName(RoleName roleName);
}
