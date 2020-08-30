package com.kingshuk.springbootprojects.springcloudconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${my.greetings}")
	private String greeting;

	@GetMapping("/hello")
	public String getGreeting() {
		return greeting;
	}

}
