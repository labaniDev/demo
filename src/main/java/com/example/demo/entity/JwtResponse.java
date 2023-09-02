package com.example.demo.entity;

import java.util.List;

import lombok.Data;
@Data
public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private Integer userid;
	private String username;
	private String password;
	private List<String> roles;

}
