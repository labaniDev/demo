package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.entity.Person;
import com.example.demo.model.PersonDTO;
import com.example.demo.repository.CountryRepo;
import com.example.demo.repository.DeveloperRepo;


@Service
public class DeveloperService {
	
	

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	DeveloperRepo developerRepo;
	@Autowired
	CountryRepo countryRepo;
	

	
	public PersonDTO saveDeveloper(PersonDTO p) {
		
		Person developer= modelMapper.map(p, Person.class);
//    	Country country= modelMapper.map(p, Country.class);
		Optional<Country> country=countryRepo.findById(p.getCountryid());
    	if(country.isPresent()) {
    		developer.setCountry(country.get());
    	}
		
		developer=developerRepo.save(developer);
		
		PersonDTO responsedto=modelMapper.map(developer, PersonDTO.class);
		return responsedto;
		
	}

//	public void rateDeveloper(Integer userid, Integer rating) {
//		Optional<Person> userOptional=developerRepo.findById (userid);
//		 if(userOptional.isPresent()) {
//			Person user=userOptional.get();
//			user.setRating(rating);
//			developerRepo.save(user);
//		
//		 }
//	
//	}
	
	
//	Login login=modelMapper.map(p,Login.class);
//	login.setUserid(developer.getUserid());
//	loginRepo.save(login);
//	
}

