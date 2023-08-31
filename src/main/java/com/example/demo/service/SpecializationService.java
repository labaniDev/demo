//package com.example.demo.service;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.Specialization;
//import com.example.demo.model.SpecializationDTO;
//import com.example.demo.repository.SpecializationRepo;
//
//@Service
//public class SpecializationService {
//	@Autowired
//	SpecializationRepo specializationRepo;
//	@Autowired
//	ModelMapper modelMapper;
//	
//	
//	public void insertSpecialization(SpecializationDTO specializationDTO){
//		
//			Specialization data= modelMapper.map(specializationDTO,Specialization.class);
//			
//			specializationRepo.save(data);
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


//}
