package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Specialization;

public interface SpecializationRepo extends CrudRepository<Specialization,Integer> {

}
