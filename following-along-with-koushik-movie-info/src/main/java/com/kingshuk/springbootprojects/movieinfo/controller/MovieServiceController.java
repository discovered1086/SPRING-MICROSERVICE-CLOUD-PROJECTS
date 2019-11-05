package com.kingshuk.springbootprojects.movieinfo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kingshuk.springbootprojects.movieinfo.domain.Movie;
import com.kingshuk.springbootprojects.movieinfo.domain.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieServiceController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.key}")
	private String apiKey;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> getMovies() {

		List<Movie> movies = Collections.singletonList(new Movie("A walk to remember", "Very nice movie"));

		return ResponseEntity.ok(movies);
	}

	/*
	 * @GetMapping(path = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<Movie> getMovie(@PathVariable("movieId") String
	 * movieId) {
	 * 
	 * return ResponseEntity.ok(new Movie(movieId, "A walk to remember",
	 * "Very nice movie")); }
	 */

	@GetMapping(path = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);

		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}

}
