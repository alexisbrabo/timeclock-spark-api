package com.timeclock.repository;

import java.util.List;

import com.timeclock.model.User;

public class UserRepository extends DefaultRepository {

	public List<User> getAllUsers() {
		return manager.createQuery("SELECT o FROM User o", User.class).getResultList();
	}

	public boolean userExist(String name) {
		List<User> userList = manager.createQuery("SELECT o FROM User o where o.name = '" + name + "'", User.class)
				.getResultList();
		return !userList.isEmpty();
	}
}
