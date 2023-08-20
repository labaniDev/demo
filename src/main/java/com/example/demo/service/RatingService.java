
package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.entity.Rating;
import com.example.demo.model.RatingDTO;
import com.example.demo.repository.DeveloperRepo;
import com.example.demo.repository.RatingRepo;

@Service
public class RatingService {
	@Autowired
	RatingRepo ratingRepo;
	
	@Autowired
	DeveloperRepo developerRepo;

	public void rateDeveloper(RatingDTO ratingDTO) {
		
		  Optional<Person> userOptional = developerRepo.findByUserid(ratingDTO.getUserid());
		  
		  if (userOptional.isPresent()) {
		 Person user= userOptional.get(); 
		 Rating rating = new Rating();
		  rating.setRatingvalue(ratingDTO.getRatingvalue());
		  rating.setPerson(user);
		  rating.setClientid(ratingDTO.getClientid());
		  ratingRepo.save(rating);
		  
		  }
		  

	}

//	public double getAverageUserRating() {
//		List<AverageRating> ratings=ratingRepo.getAverageRating(null)
//		
//		if (ratings != null && !ratings.isEmpty()) {
//			ratings.
//		}
//		
		
		
		
		
	
		  
		
		
	}


