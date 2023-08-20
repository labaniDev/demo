package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String projectname;
	private String projectdescription;
	private boolean archieve;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="userid",nullable=false)
//	private Person person;
	
	@ManyToMany(mappedBy = "projects")
	private List<Person> persons = new ArrayList<Person>();
}