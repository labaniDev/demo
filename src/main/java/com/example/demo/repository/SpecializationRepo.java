package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Person;
import com.example.demo.entity.Specialization;

public interface SpecializationRepo extends CrudRepository<Specialization,Integer>,JpaRepository<Specialization,Integer> {
	
	Optional<Specialization> findBySkillname(String skillname);

}
