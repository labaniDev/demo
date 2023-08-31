package com.example.demo.model;

import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PersonDTO {
	private Integer userid;
	private String firstname;
	private String lastname;
	private String dob;
	private double hourlyrate;
	private String profilesummary;
	//private String specialization;
	private Double yearofexperience;
	//@JsonIgnore
	private Integer countryid;
	private String username;
	private String password;
	private String skillname;
	private Set<String> role;
	
	
	
//	private String username;
//	private String password;
	
	
	
//	private Integer tid;
//	private Integer starttime;
//	private Integer endtime;
//	private Integer duration;
//	
	
	
	
//	private int SkillId;
//	private String Skills;
	
}
