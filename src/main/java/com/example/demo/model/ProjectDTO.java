package com.example.demo.model;

import lombok.Data;

@Data
public class ProjectDTO {
	private Integer pid;
	private Integer userid;
	private String projectname;
	private String Projectdescription;
	private boolean archieve;
}
