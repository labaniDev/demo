package com.example.demo.model;

import lombok.Data;

@Data
public class TimesheetDTO {
	
	
	private Integer tid;
	private Integer cid;
	private Integer userid;
	private Integer pid;
	private String startTime;
	private String endtime;
	private long duration;

}
