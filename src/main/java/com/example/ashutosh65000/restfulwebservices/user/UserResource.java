package com.example.ashutosh65000.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// GET all Users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}

	// GET a particular User
	@GetMapping("/users/{id}")
	public User getParticularUser(@PathVariable int id) {
		return service.findParticular(id);
	}
	
	// POST user
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		User added=service.add(user);
	}
}
