package com.example.demo.entity;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "timesheet")
@Data
public class Timesheet {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Time starttime;
	private Time endtime;
	private Long duration;
	private Integer cid;
	
	
	@ManyToOne
	@JoinColumn(name="pid", nullable=false)
    private Project project;
	
	@ManyToOne
	@JoinColumn(name="userid", nullable=false)
    private Person person;



}
