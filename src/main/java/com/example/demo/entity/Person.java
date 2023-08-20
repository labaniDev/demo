package com.example.demo.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String firstname;
	private String lastname;

	private String dob;
	private Double hourlyrate;
	private String profilesummary;
	private String specialization;
	private Double yearofexperience;
	
	
	
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)               
    @JoinColumn(name="countryid", nullable=false)
    private Country country;


	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	    name = "person_project",
	    joinColumns = {  @JoinColumn(name = "userid")},
	    inverseJoinColumns = {  @JoinColumn(name = "pid")}) 
	private List<Project> projects;
	
	
	
//   @OneToMany(mappedBy="person")
//   private List<Rating> ratings;
   
//   @OneToMany(mappedBy="person")
//   private List<Review> reviews;
   
	
}
	
	