package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="revenue")
public class Revenue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer revid;
	private Integer userid;
	private Integer pid;
	private Integer projectname;
	private Integer totalearning;
}
	
//	@OneToMany(mappedBy="person")
//	private Set<Person> person;
//}
//	
