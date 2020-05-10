package com.kingshuk.springbootprojects.moviecatalogue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kingshuk.springbootprojects.moviecatalogue.domain.CatalogueItem;
import com.kingshuk.springbootprojects.moviecatalogue.domain.Movie;
import com.kingshuk.springbootprojects.moviecatalogue.domain.Rating;
import com.kingshuk.springbootprojects.moviecatalogue.domain.UserRating;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

	@Autowired
	private RestTemplate restTemplate;

	//@Autowired
	//private WebClient.Builder webClientBuilder;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	

	@GetMapping("/")
	public String hello() {
		return "Welcome to the catalogue service";
	}

	@GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CatalogueItem>> getCatalogue(@PathVariable("userId") String userId) {

		List<CatalogueItem> catalogueItems = new ArrayList<>();

		/*
		 * @SuppressWarnings("unchecked") List<Rating> userRatings =
		 * webClientBuilder.build().get().uri("http://localhost:8083/ratings/users/" +
		 * userId) .retrieve().bodyToMono(ArrayList.class).block();
		 */

		// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" +
		// rating.getMovieId(), Movie.class);

		ResponseEntity<UserRating> userRatings = restTemplate.exchange(
				"http://rating-service/ratings/users/" + userId, HttpMethod.GET, null,
				new ParameterizedTypeReference<UserRating>() {
				});
			
		List<Rating> userRatingslist = new ArrayList<>();
		
		if(userRatings.hasBody()) {
			userRatingslist.addAll(userRatings.getBody().getRatings());
		}

		for (Rating rating : userRatingslist) {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

			catalogueItems.add(new CatalogueItem(movie.getTitle(), movie.getDescription(), rating.getMovieRating()));
		}

		/*
		 * Function<Rating, CatalogueItem> catalogFunction = rating -> { Movie movie =
		 * restTemplate.getForObject("http://localhost:8082/movies/" +
		 * rating.getMovieId(), Movie.class);
		 * 
		 * return new CatalogueItem(movie.getTitle(), movie.getDescription(),
		 * rating.getMovieRating()); };
		 * 
		 * catalogueItems =
		 * userRatings.stream().map(catalogFunction).collect(Collectors.toList());
		 */

		/*
		 * userRatings.forEach(rating -> { Movie movie =
		 * restTemplate.getForObject("http://localhost:8082/movies/" +
		 * rating.getMovieId(), Movie.class);
		 * 
		 * catalogueItems.add(new CatalogueItem(movie.getTitle(),
		 * movie.getDescription(), rating.getMovieRating())); });
		 */

		return ResponseEntity.ok(catalogueItems);
	}

}
