package com.timeclock.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.timeclock.database.JpaUtils;
import com.timeclock.model.User;

public class UserServiceImpl implements UserService {
	
	EntityManager manager = JpaUtils.getEntityManager();

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User editUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
