package com.example.demo.model;

import lombok.Data;

@Data
public class RatingDTO {
	private Integer userid;
	private Integer ratingid;
	private Integer clientid;
	private Double ratingvalue;
	
}
