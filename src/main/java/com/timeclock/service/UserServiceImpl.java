package com.timeclock.service;

import java.util.List;

import com.timeclock.model.User;
import com.timeclock.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	UserRepository userRepository = new UserRepository();

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
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
