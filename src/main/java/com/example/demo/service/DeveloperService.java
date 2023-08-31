package com.example.demo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.entity.Erole;
import com.example.demo.entity.Person;
import com.example.demo.entity.Role;
import com.example.demo.entity.Specialization;
import com.example.demo.model.PersonDTO;
import com.example.demo.repository.CountryRepo;
import com.example.demo.repository.DeveloperRepo;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.SpecializationRepo;

@Service
public class DeveloperService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	DeveloperRepo developerRepo;
	@Autowired
	CountryRepo countryRepo;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder encoder;
	@Autowired
	SpecializationRepo specializationRepo;

	public void saveDeveloper(PersonDTO p) {

		Set<Role> roles = new HashSet<>();
		Person developer = modelMapper.map(p, Person.class);
		developer.setPassword(encoder.encode(developer.getPassword()));
//    	Country country= modelMapper.map(p, Country.class);
		if (p.getCountryid() != null) {
			Optional<Country> country = countryRepo.findById(p.getCountryid());
			if (country.isPresent()) {
				developer.setCountry(country.get());
			}
			}
		

		if (p.getRole() == null) {
			Role userRole = roleRepo.findByName(Erole.roleuser)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		}
//		if(p.getRole()==null) {
//			Role adminRole = roleRepo.findByName(Erole.roleadmin);
//			roles.add(adminRole);
//		}

		developer.setRoles(roles);

		developerRepo.save(developer);

	}


		
//public void insertSpecialization(PersonDTO p) {
//	Person developer = modelMapper.map(p, Person.class);
//		if(p.getSkillname()!=null) {
//			Optional<Specialization> specialization=specializationRepo.findBySkillname(p.getSkillname());
//			if(specialization.isPresent()) {
//				developer.getSpecializations().add(specialization.get());
//			}
//		}
//}
		
	
	
	
	
	

	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return developerRepo.existsByUsername(username);
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

	// countryRepo.findById(p.getCountryid())

//	Login login=modelMapper.map(p,Login.class);
//	login.setUserid(developer.getUserid());
//	loginRepo.save(login);
//	
}
