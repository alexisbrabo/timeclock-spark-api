package com.timeclock.main;

import static spark.Spark.after;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static spark.Spark.put;

import javax.persistence.Persistence;

import com.google.gson.Gson;
import com.timeclock.model.User;
import com.timeclock.service.UserServiceImpl;

public class TimeClock {

	public static UserServiceImpl userService = new UserServiceImpl();

	public static void main(String[] args) {
		// Create necessary tables
		Persistence.createEntityManagerFactory("TimeClockPU");

		final Gson gson = new Gson();

		// GZIP everything
		after((request, response) -> {
			response.header("Content-Encoding", "gzip");
		});
		
		//***************************************User Routes*****************************************************************************************

		get("/users", (req, res) -> {
			res.type("application/json");
			return userService.getAllUsers();
		}, gson::toJson);

		post("/user", (req, res) -> {
			res.type("application/json");
			User user = gson.fromJson(req.body(), User.class);
			if (userService.userExist(user.getName())) {
				halt(400, gson.toJson("User already exists in database!"));
			}
			userService.addUser(user);
			res.status(201);
			return user;
		}, gson::toJson);

		put("/user/:id", (req, res) -> {
			res.type("application/json");
			User userToEdit = gson.fromJson(req.body(), User.class);
			userToEdit.setId(Integer.parseInt(req.params(":id")));
			userService.editUser(userToEdit);
			res.status(200);
			return userToEdit;
		}, gson::toJson);

		delete("/user/:id", (req, res) -> {
			res.type("application/json");
			userService.deleteUser(Integer.parseInt(req.params(":id")));
			res.status(204);
			return "Usuário Deletado";
		}, gson::toJson);
		
		
	}

}
