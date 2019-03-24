package com.kingshuk.springbootprojects.movieinfo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springbootprojects.movieinfo.domain.Movie;

@RestController
@RequestMapping("/movies")
public class MovieServiceController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> getMovies() {

		List<Movie> movies = Collections.singletonList(new Movie("A walk to remember", "Very nice movie"));

		return ResponseEntity.ok(movies);
	}

	/*@GetMapping(path = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> getMovie(@PathVariable("movieId") String movieId) {

		return ResponseEntity.ok(new Movie(movieId, "A walk to remember", "Very nice movie"));
	}*/
	
	@GetMapping(path = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie getMovie(@PathVariable("movieId") String movieId) {

		return new Movie(movieId, "A walk to remember", "Very nice movie");
	}

}
