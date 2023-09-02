//package com.example.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//
//import com.example.demo.entity.Person;
//import com.example.demo.entity.RefreshToken;
//
//
//public interface RefreshTokenRepo extends JpaRepository<RefreshToken,Long> {
//	
//	RefreshToken  findByToken(String token);
//	
//	 @Modifying
//	  int deleteByuser(Person person);
//
//}
