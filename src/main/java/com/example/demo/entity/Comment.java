package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="comment")
public class Comment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
	private Integer commentid;
	private Integer parentid;
	private String comment;
	
//    @OneToMany(mappedBy="parentcomment")
//	private List<CommentReply> commentReply;
//	
	
	 @ManyToOne
	 @JoinColumn(name = "userid")
	  private Person person;
	

}
