package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.WebappService;

@RestController
public class UserController {
	
    @Value("${server.port}")
    private String port;
    
    @Autowired
    private WebappService webappService;
	
	@GetMapping("/test")
	public String test() {
	String clientInfo=	webappService.getTesting();
	System.out.println("Cliet info"+clientInfo);
		return "abc"+clientInfo;
	}
	
	@GetMapping("/test/test")
	public String testers() {
		return "TestersTesters";
	}
	
	@GetMapping("/call-webapp")
	public String callWebapp() {
		return "Response from webapp: " + webappService.getTesting();
	}

}
