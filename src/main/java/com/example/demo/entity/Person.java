package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Double yearofexperience;
	private String username;
	private String password;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "countryid", nullable = false)
	private Country country;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "person_project", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "pid") })
	private Set<Project> projects =new HashSet<>();
	
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "id"))
	private Set<Role> roles = new HashSet<>();

//   @OneToMany(mappedBy="person")
//   private List<Rating> ratings;

//   @OneToMany(mappedBy="person")
//   private List<Review> reviews;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="person_specialization", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "skillid"))
	private Set<Specialization> specializations = new HashSet<>();
	

}
