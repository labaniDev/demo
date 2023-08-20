package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.projections.AverageRatingProjectionDTO;
import com.example.demo.repository.RatingRepo;
@Service
public class AverageRatingService {
	
	@Autowired
	RatingRepo ratingRepo;
	
	
	public double getAverageUserRating(Integer userid) {
		
		List<AverageRatingProjectionDTO> ratings=ratingRepo.getAverageRating(userid);
		if(ratings.get(0)!=null) {
			return ratings.get(0).getAvgRating();
		
		
		
		
		}
		return 0.0;
		
	}
	
}


