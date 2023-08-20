package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.SpecializationRepo;


public class SpecializationService {
	@Autowired
	SpecializationRepo specializationRepo;
	@Autowired
	ModelMapper modelMapper;
//	
//	
//	public List<SpecializationDTO> getAllSpecialization(){
//		List<Specialization> specializationList= specializationRepo.findAll();
//		List<SpecializationDTO> specializationDtoLis=modelMapper.map(postEntity, new TypeToken<List<PostDTO>>(){}.getType());
//	}
	
//public List<SpecializationDTO> getAllSpecialization(){
//	 
//		ArrayList<Specialization> specializationList=(ArrayList<Specialization>) specializationRepo.findAll();
//		
//		
//		List<SpecializationDTO>specializationDtoList=modelMapper.map(specializationToken<List<specializationDTO>>(){}.getType());
//	return specializationDtoList;
//	
//	}


}
