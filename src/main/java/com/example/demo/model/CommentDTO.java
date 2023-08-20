package com.example.demo.model;

import lombok.Data;

@Data
public class CommentDTO {
	private String username;
	private Integer commentid;
	private Integer userid;
	private Integer parentid;
	private String comment;


}
