package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.entity.Comment;
import com.example.demo.model.CommentDTO;
import com.example.demo.repository.DeveloperRepo;
import com.example.demo.repository.CommentRepo;

@Service
public class CommentService {
	
	
	@Autowired
	CommentRepo commentRepo;
	@Autowired
	DeveloperRepo developerRepo;
	
	
	 public void createReview(CommentDTO commentDTO) {
	        Optional<Person> userOptional= developerRepo.findByUserid(commentDTO.getUserid());
	        
	        if (userOptional.isPresent()) {
	        	 Person user= userOptional.get();
	            Comment review = new Comment(); 
	            if(commentDTO.getParentid()!=null)
	            review.setParentid(commentDTO.getParentid());	
	            else
	            review.setParentid(0);	
	            review.setPerson(user);
	            review.setComment(commentDTO.getComment());
	            
	            commentRepo.save(review);

}
	        
	        
	        
	        
	        
	 }
	 
	 
//	 public void createReply(int parentid,CommentDTO commentDTO) {
//		 Comment parentcomment=
//	 }
	 
	 
}

