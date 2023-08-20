package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Revenue;



@Repository
public interface RevenueRepo extends CrudRepository<Revenue,Integer>,JpaRepository<Revenue,Integer>{
	
	
	
	Optional<Revenue> findById(Integer userId);
	
}
