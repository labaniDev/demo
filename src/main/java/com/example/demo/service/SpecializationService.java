package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.entity.Project;
import com.example.demo.entity.Specialization;
import com.example.demo.model.ProjectDTO;
import com.example.demo.model.SpecializationDTO;
import com.example.demo.repository.DeveloperRepo;
import com.example.demo.repository.SpecializationRepo;

@Service
public class SpecializationService {
	@Autowired
	SpecializationRepo specializationRepo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	DeveloperRepo developerRepo;
	
	
public void createSpecialization(SpecializationDTO specializationDTO) {
		
		Optional<Person> userOptional = developerRepo.findById(specializationDTO.getUserid());
		if (userOptional.isPresent()) {
			Person user = userOptional.get();
			Specialization specialization = new Specialization();
			specialization.setSkillname(specializationDTO.getSkillname());
			
			specialization.getPersons().add(user);

			//Project create = modelMapper.map(admin, Project.class);
			@SuppressWarnings("unused")
			Specialization createdSpecialization = specializationRepo.save(specialization);
		}
	}
	
public List<SpecializationDTO> getAllSpecialization(){
	 
		ArrayList<Specialization> specializationList=(ArrayList<Specialization>) specializationRepo.findAll();
		
		
		List<SpecializationDTO> specializationDtoList= modelMapper.map(specializationList,new TypeToken<List<SpecializationDTO>>() {}.getType() );
	return specializationDtoList;
	
	}


}
