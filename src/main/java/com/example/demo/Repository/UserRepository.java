package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 
	User findByUsername(String username);
	User findByFirstName(String username);
	List<User> findByRoles(String roles);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
