package com.kingshuk.microservices.followingjoshlongconsigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//Now  I'm  going to tell the application that's it is a config server
@EnableConfigServer
public class FollowingAlongWithJoshLongConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowingAlongWithJoshLongConfigServerApplication.class, args);
	}

}
