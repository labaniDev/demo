package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="specialization")
public class Specialization {
	@Id
	private Integer skillid;
	private String skillname;

}
