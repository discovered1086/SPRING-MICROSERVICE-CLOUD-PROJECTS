package com.kingshuk.springbootprojects.moviecatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class FollowingAlongWithKoushikMovieCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowingAlongWithKoushikMovieCatalogueApplication.class, args);
	}

	/*
	 * @Bean
	 * 
	 * @LoadBalanced public RestTemplate getRestTemplate() { RestTemplateBuilder
	 * restTemplateBuilder = new RestTemplateBuilder();
	 * restTemplateBuilder.setConnectTimeout(Duration.ofMinutes(1l)); return
	 * restTemplateBuilder.build(); }
	 */

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		return new RestTemplate(requestFactory);
	}

	@Bean
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}

}
