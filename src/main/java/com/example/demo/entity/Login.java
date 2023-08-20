//package com.example.demo.entity;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import lombok.Data;
//@Entity
//@Data
//public class Login {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private Integer userid;
//	private String username;
//	private String password;
//	
//	 public Login(String username,String password) {
//		    this.username = username;
//		   
//		    this.password = password;
//		  }
//	
//	
//	
//	@ManyToMany(fetch = FetchType.LAZY)
//	  @JoinTable(name = "userroles", 
//	             joinColumns = @JoinColumn(name = "userid"),
//	             inverseJoinColumns = @JoinColumn(name = "roleid"))
//	  private Set<Role> roles = new HashSet<>();
//
//
//
//	
//
//}
