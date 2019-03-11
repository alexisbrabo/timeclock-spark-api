package com.timeclock.main;

import static spark.Spark.get;

import javax.persistence.Persistence;

import com.google.gson.Gson;
import com.timeclock.service.UserServiceImpl;

public class TimeClock {
	public static UserServiceImpl userService = new UserServiceImpl();

	public static void main(String[] args) {
		// Create necessary tables
		Persistence.createEntityManagerFactory("TimeClockPU");

		final Gson gson = new Gson();

		get("/hello", (req, res) -> {
			res.type("application/json");
			return userService.getAllUsers();
		}, gson::toJson);
	}

}
