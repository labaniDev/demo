package com.example.demo.entity;

import lombok.Data;

@Data
public class MessageResponse {
	 private String message;
	 
	 public MessageResponse(String message) {
		    this.message = message;
		  }

		  public String getMessage() {
		    return message;
		  }

		  public void setMessage(String message) {
		    this.message = message;
		  }
		}
	 



