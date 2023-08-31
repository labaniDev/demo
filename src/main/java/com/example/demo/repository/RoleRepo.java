package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Erole;
import com.example.demo.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	

	Optional<Role> findByName(Erole role);

}
