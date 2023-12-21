package com.example.demo.model;

import com.example.demo.entity.Status;

import lombok.Data;

@Data
public class ProjectDTO {
	private Integer pid;
	private Integer userid;
	private String projectname;
	private String projectdescription;
	private Status status;
}
