package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.model.CommentDTO;
import com.example.demo.projections.CommentProjectionDTO;
import com.example.demo.repository.CommentRepo;

@Service
public class CommentReplyService {
	@Autowired
	CommentRepo commentRepo;
	
	public void createCommentReply(CommentDTO commentDTO) {
		List<CommentProjectionDTO> parentComment=commentRepo.findByParentid(commentDTO.getParentid());
		if(parentComment!=null && !parentComment.isEmpty()) {
			CommentProjectionDTO parent=parentComment.get(0);
			
			Comment reply=new Comment();
			reply.setCommentid(parent.getCommentid());
			reply.setComment(commentDTO.getComment());
			
			commentRepo.save(reply);
			
		}
		
	}
}
	//}

//}
