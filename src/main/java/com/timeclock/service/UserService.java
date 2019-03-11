package com.timeclock.service;

import java.util.List;

import com.timeclock.model.User;

public interface UserService {

	public void addUser(User user);
	
	public List<User> getAllUsers();
	
	public User editUser(User user);
	
	public void deleteUser(String id);
	
	public boolean userExist(String id);
	
}
