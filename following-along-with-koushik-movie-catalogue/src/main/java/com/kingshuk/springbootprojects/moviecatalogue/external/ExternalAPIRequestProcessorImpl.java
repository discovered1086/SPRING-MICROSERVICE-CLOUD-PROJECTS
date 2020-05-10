package com.kingshuk.springbootprojects.moviecatalogue.external;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kingshuk.springbootprojects.moviecatalogue.domain.Movie;
import com.kingshuk.springbootprojects.moviecatalogue.domain.Rating;
import com.kingshuk.springbootprojects.moviecatalogue.domain.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ExternalAPIRequestProcessorImpl implements ExternalAPIRequestProcessor {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackRating")
	public List<Rating> getAllUserRatings(String userId) {

		ResponseEntity<UserRating> userRatings = restTemplate.exchange("http://rating-service/ratings/users/" + userId,
				HttpMethod.GET, null, new ParameterizedTypeReference<UserRating>() {
				});

		List<Rating> userRatingslist = new ArrayList<>();

		if (userRatings.hasBody()) {
			userRatingslist.addAll(userRatings.getBody().getRatings());
		}

		return userRatingslist;
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackMovie")
	public Movie getMovie(Rating rating) {
		return restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
	}

	@SuppressWarnings("unused")
	public List<Rating> getFallbackRating(String userId) {
		return Arrays.asList(Rating.builder().movieId(2).movieRating(4.5).build());
	}

	@SuppressWarnings("unused")
	public Movie getFallbackMovie(Rating rating) {
		return Movie.builder().description("Kill bill volume 2").title("Kill bill volume 2").movieId("2").build();
	}

}
