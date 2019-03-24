package com.kingshuk.springbootprojects.ratingservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springbootprojects.ratingservice.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	/*@GetMapping(path="/users/{userId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rating>> getRating(@PathVariable("userId") String userId) {
		return ResponseEntity.ok(Arrays.asList(new Rating(1234, 7), new Rating(2569, 6.5)));
	}*/
	
	@GetMapping(path="/users/{userId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Rating> getRating(@PathVariable("userId") String userId) {
		return Arrays.asList(new Rating(1234, 7), new Rating(2569, 6.5));
	}

}
