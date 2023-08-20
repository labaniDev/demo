package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Calender;


@Repository
public interface CalenderRepo extends JpaRepository<Calender, Integer>, CrudRepository<Calender, Integer> {

	public Calender findByDayAndMonthAndYear(Integer day, Integer month, Integer year);
}
