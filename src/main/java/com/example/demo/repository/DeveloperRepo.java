package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;
import com.example.demo.entity.Comment;

@Repository
public interface DeveloperRepo extends JpaRepository<Person, Integer>, CrudRepository<Person, Integer> {

	Optional<Person> findByUserid(Integer userid);

	Comment save(Comment user);

	Optional<Person> findByUsername(String username);

	Boolean existsByUsername(String username);

	

}
