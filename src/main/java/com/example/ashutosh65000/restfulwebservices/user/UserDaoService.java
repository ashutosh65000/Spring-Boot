package com.example.ashutosh65000.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new User(1, "Ashutosh Srivastava", new Date()));
		users.add(new User(2, "Satyam Tewari", new Date()));
		users.add(new User(3, "Shivansh Bajpai", new Date()));
	}

	// Return all users
	public List<User> findAll() {
		return users;
	}

	// Return a particular user
	public User findParticular(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	// Add a user
	public User add(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
}
