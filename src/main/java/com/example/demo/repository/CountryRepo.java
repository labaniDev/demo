package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Country;


@Repository
public interface CountryRepo extends CrudRepository<Country, Integer>,JpaRepository<Country, Integer> {

}
