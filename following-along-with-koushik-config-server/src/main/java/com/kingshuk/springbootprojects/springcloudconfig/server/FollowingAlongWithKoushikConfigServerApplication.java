package com.kingshuk.springbootprojects.springcloudconfig.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class FollowingAlongWithKoushikConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowingAlongWithKoushikConfigServerApplication.class, args);
	}

}
