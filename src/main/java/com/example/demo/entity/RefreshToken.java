//package com.example.demo.entity;
//
//import java.time.Instant;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//import lombok.Data;
//@Entity
//@Data
//public class RefreshToken {
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//	private Long refreshid;
//	
//	@Column(nullable = false, unique = true)
//	private String token;
//	 
//	 @Column(nullable = false)
//	private Instant expiryDate;
//	
//	 @OneToOne
//	  @JoinColumn(name = "userid", referencedColumnName = "refreshid")
//	  private Person user;
//
//	
//
//}
