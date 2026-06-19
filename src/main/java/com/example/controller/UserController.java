package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
    @Value("${server.port}")
    private String port;
	
	@GetMapping("/test")
	public String test() {
		return "Testers>>"+port;
	}
	
	@GetMapping("/test/test")
	public String testers() {
		return "TestersTesters";
	}

}
