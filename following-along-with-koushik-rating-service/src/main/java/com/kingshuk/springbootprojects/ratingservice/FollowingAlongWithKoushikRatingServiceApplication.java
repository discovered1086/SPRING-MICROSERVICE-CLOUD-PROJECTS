package com.kingshuk.springbootprojects.ratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FollowingAlongWithKoushikRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowingAlongWithKoushikRatingServiceApplication.class, args);
	}

}
