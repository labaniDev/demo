package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RevenueService;

@RestController
@RequestMapping("/api/revenue")
@CrossOrigin(origins = "*")
public class RevenueController {
	@Autowired
	RevenueService revenueService;
	
	
	@GetMapping("/totalearning/{userid}/{pid}")
	public ResponseEntity<Double> calculateTotalEarnings(@PathVariable Integer userid,@PathVariable Integer pid) {
		double totalearning=revenueService.getTotalSalary(userid,pid);
		return ResponseEntity.ok(totalearning);
	}
	
//	@PostMapping("/create")
//	public ResponseEntity<Boolean> createuser(RevenueDTO revenueDTO) {
//		revenueService.saveuser(revenueDTO);
//		return new ResponseEntity<Boolean>(HttpStatus.CREATED);
//	}
}

	
	

