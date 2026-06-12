package com.stackly.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.dto.UserDto;
import com.stackly.demo.entity.Address;
import com.stackly.demo.entity.Role;
import com.stackly.demo.entity.RoleName;
import com.stackly.demo.entity.User;
import com.stackly.demo.repository.RoleRepository;
import com.stackly.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	private UserRepository userRepo;
	
	private RoleRepository roleRepo;

	public UserServiceImpl(UserRepository userRepo,RoleRepository roleRepo)
	{
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}
	
	
	@Override
	public ResponseEntity<?> registerUser(UserDto dto)
	{
		User user = new User();
		
		user.setUserName(dto.getUserName());
		
		user.setUserPass(dto.getUserPass());
		
		user.setEmail(dto.getEmail());

		user.setPhoneNumber(dto.getPhoneNumber());
		
		
		List<Address> addressList = dto.getAddress()
				.stream().map(data -> {
					
					Address address = new Address();
					
					address.setStreet(data.getStreet());

                    address.setCity(data.getCity());

                    address.setState(data.getState());

                    address.setPincode(data.getPincode());
                    
                    address.setUser(user);
                    
                    return address;
				})
				.toList();
		
		user.setAddresses(addressList);
		
		Role role = roleRepo.findByRoleName(RoleName.CUSTOMER).orElseThrow(() -> new RuntimeException("Role not found"));
		
		user.getRoles().add(role);
		userRepo.save(user);
		
		return ResponseEntity.ok(
				new APIResponse<>(LocalDateTime.now(),200,"User Registered Successfully",user)
				);
	}

	@Override
	public ResponseEntity<?> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
