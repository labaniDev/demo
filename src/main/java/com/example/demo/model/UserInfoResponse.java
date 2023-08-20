package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class UserInfoResponse {
	
	Integer userid;
	String username;
	List<String> roles;

	public UserInfoResponse(Integer userid,String username, List<String> roles) {
		this.userid=userid;
		this.username=username;
		this.roles=roles;
		
	}

}
