package com.kingshuk.springbootprojects.springcloudconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ConfigurationProperties(prefix = "my")
@Configuration
public class MyProperties {
	
	private String name;
	private Gender gender;
	private int age;

}
