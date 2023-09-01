package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.entity.Role;
import com.example.demo.model.RoleDTO;
import com.example.demo.repository.DeveloperRepo;
import com.example.demo.repository.RoleRepo;

@Service
public class RoleService {
	@Autowired
	DeveloperRepo developerRepo;
	@Autowired
	RoleRepo roleRepo;
	
public void createRole(RoleDTO roleDTO) {
		
		Optional<Person> userOptional = developerRepo.findById(roleDTO.getUserid());
		if (userOptional.isPresent()) {
			Person user = userOptional.get();
			Role role = new Role();
			role.setName(roleDTO.getName());
			
			roleRepo.save(role);


		}
	}
	

}
