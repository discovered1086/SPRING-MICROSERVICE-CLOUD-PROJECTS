package com.kingshuk.springbootprojects.springcloudconfig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springbootprojects.springcloudconfig.config.MyProperties;

@RestController
public class MyController {

	@Value("${my.greetings:Hello from the default value}")
	private String greeting;

	@Value("Hello from hardcoded String")
	private String greeting2;

	@Value("${my.list.value}")
	private List<String> listOfStrings;

	@Value("#{${userLocation}}")
	private Map<String, String> friendsLocations;

	@Autowired
	private MyProperties myProperties;
	
	@Autowired
	private Environment environment;

	@GetMapping("/hello")
	public String getGreeting() {
		return greeting;
	}

	@GetMapping(path = "/hello-list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getGreetingList() {
		return listOfStrings;
	}

	@GetMapping(path = "/hello-friends", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getGreetingFriends() {
		return friendsLocations;
	}

	@GetMapping("/my-details")
	public String getAllMyProperties() {
		return "Hi I'm " + myProperties.getName() + ". I'm a" + myProperties.getAge() + " year old "
				+ myProperties.getGender().name().toLowerCase();
	}
	
	@GetMapping("/environment")
	public String getEnvironmentDetails() {
		return environment.toString();
	}

}
