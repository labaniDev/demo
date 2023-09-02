package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.Specialization;
import com.example.demo.model.RoleDTO;
import com.example.demo.model.SpecializationDTO;
import com.example.demo.repository.DeveloperRepo;
import com.example.demo.repository.RoleRepo;

@Service
public class RoleService {
	@Autowired
	DeveloperRepo developerRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	ModelMapper modelMapper;
	
//public void createRole(RoleDTO roleDTO) {
//		
//		Optional<Person> userOptional = developerRepo.findById(roleDTO.getUserid());
//		if (userOptional.isPresent()) {
//			Person user = userOptional.get();
//			Role role = new Role();
//			role.setName(roleDTO.getName());
//			
//			roleRepo.save(role);
//
//
//		}
//	}

public void saveRole(RoleDTO roleDTO) {
	Role data= modelMapper.map(roleDTO,Role.class);
	
	roleRepo.save(data);
	

}

public List<RoleDTO> getAllRole(){
	 
	ArrayList<Role> Rolelist=(ArrayList<Role>) roleRepo.findAll();
	
	
	List<RoleDTO> RoleDTOList= modelMapper.map(Rolelist,new TypeToken<List<RoleDTO>>() {}.getType() );
return RoleDTOList;

}
}
