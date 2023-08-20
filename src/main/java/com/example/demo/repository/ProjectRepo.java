package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;
@Repository
public interface ProjectRepo  extends CrudRepository<Project,Integer>,JpaRepository<Project,Integer>{
	Optional<Project> findById(Integer pid);
	
	List<Project> findByArchieve(boolean archieve);

}
