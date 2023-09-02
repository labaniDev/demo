package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class UserInfoResponse {
	
	Integer userid;
	String username;
	List<String> roles;
	String jwtToken;

	public UserInfoResponse(Integer userid,String username, List<String> roles,String jwt) {
		this.userid=userid;
		this.username=username;
		this.roles=roles;
		this.jwtToken=jwt;
	}

}
