package com.timeclock.service;

import java.util.List;

import com.timeclock.model.User;
import com.timeclock.repository.UserRepository;

public class UserServiceImpl implements UserService {

	UserRepository userRepository = new UserRepository();

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public void editUser(User user) {
		userRepository.update(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.delete(userRepository.findById(User.class, id));
	}

	@Override
	public boolean userExist(String name) {
		return userRepository.userExist(name);
	}

}
