package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RatingDTO;
import com.example.demo.service.RatingService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RatingController {
	@Autowired
	RatingService ratingService;
//	to give rating to developer	
	@PostMapping("/rating")
	public ResponseEntity<String> rateDeveloper(@RequestBody RatingDTO ratingDTO) {
		ratingService.rateDeveloper(ratingDTO);
		return ResponseEntity.ok("Developer rated Successfully");

	}
//	@GetMapping("/avgrating/{userid}")
//	public ResponseEntity<List< AverageRatingDTO >> getAverageRating(@PathVariable("userid") Integer userid) {
//		List<AverageRatingDTO> averageRating=ratingService.getAverageUserRating(person);
//		return  ResponseEntity.ok(averageRating);
//	}
}
