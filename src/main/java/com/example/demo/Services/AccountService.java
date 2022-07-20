package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entity.User;


public interface AccountService {
	  User addNewUser(User appUser);
	  User loadUserByUsername (String username);
	    List<User> listUser();
	    User getUserById(Long id);
	    User updateUser(User appUser, Long id);
	    String deleteUser(Long id);
	    User getUserByFirstName(String firstname);



	 
}