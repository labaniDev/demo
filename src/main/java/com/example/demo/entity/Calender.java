package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Calender {
	
	
	@Id
	private Integer cid;
	
	private Integer day;
	
	private Integer month;
	
	private Integer year;
	

}
