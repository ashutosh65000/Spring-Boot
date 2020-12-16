package com.example.ashutosh65000.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// GET all Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}

	// GET a particular User
	@GetMapping("/user/{id}")
	public User getParticularUser(@PathVariable int id) {
		return service.findParticular(id);
	}

	// POST user
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User added = service.add(user);
		
		// 1.) we want to send back the created users URI like /users/{id}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()  			// is done to remove the hard coding of /users
				.path("/{id}")			
				.buildAndExpand(added.getId())	// to provide value to {id}
				.toUri();
		
		// 1.) we want to set the HTTP Status as 201 Created
		return ResponseEntity.created(location).build();
		
		/* 
		 * the below return is used to return the body as response
		 * return ResponseEntity.created(location).body(added);
		*/
	}
}
