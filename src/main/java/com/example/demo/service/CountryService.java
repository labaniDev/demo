package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.model.CountryDTO;
import com.example.demo.repository.CountryRepo;

@Service
public class CountryService {
	
	
	@Autowired
	CountryRepo countryRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	
	public List<CountryDTO> getAllCountry(){
		
		List<Country> countryList=countryRepo.findAll();
		
		
		List<CountryDTO> countryDTOList= modelMapper.map(countryList,new TypeToken<List<CountryDTO>>() {}.getType() );
	return countryDTOList;
	
	}
	
//	public void saveCountry(CountryDTO countryDTO) {
//		Country 
//		countryRepo.save(usercountry);
//	}

}
