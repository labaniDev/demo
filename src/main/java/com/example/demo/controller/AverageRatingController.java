package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AverageRatingService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AverageRatingController {
	@Autowired
	AverageRatingService averageRatingService;
	
	@GetMapping("/avgrating/{userid}")
	public ResponseEntity<Double> getAverageRating(@PathVariable("userid") Integer userid) {
		double avgRating=averageRatingService.getAverageUserRating(userid);
		return ResponseEntity.ok(avgRating);
	}

}
