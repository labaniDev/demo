package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CommentDTO;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	 @PostMapping("/review")
	 public ResponseEntity<String> createReview(@RequestBody CommentDTO reviewDTO) {
		 commentService.createReview(reviewDTO);
	        return ResponseEntity.ok("Review created successfully.");
	    }
	 @PostMapping("/createcomment")
	 public ResponseEntity<Boolean> createComment(@RequestBody CommentDTO commentDTO) {
		commentService.createReview(commentDTO);
		 return  new ResponseEntity<Boolean>(HttpStatus.OK);
	 }
}
