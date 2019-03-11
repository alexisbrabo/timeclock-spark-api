package com.timeclock.main;

import static spark.Spark.*;

import javax.persistence.Persistence;

public class TimeClock {

	public static void main(String[] args) {
		
		//Create necessary tables
		Persistence.createEntityManagerFactory("TimeClockPU");
		
		get("/hello", (req, res) -> "Hello World");
	}

}
