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

@Entity
@Data
@Table(name="specialization")
public class Specialization {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer skillid;
	private String skillname;
	
	
	@ManyToMany(mappedBy = "specializations")
	private List<Person> persons = new ArrayList<Person>();
	
}
