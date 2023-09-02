package com.example.demo.model;

import java.time.Instant;

import lombok.Data;
@Data
public class RefreshTokenDTO {
	
	private Long refreshid;
	private String token;
	private Instant expiryDate;
	private Integer userid;

}
