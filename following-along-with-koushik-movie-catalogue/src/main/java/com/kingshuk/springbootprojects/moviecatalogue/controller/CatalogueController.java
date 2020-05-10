package com.kingshuk.springbootprojects.moviecatalogue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.springbootprojects.moviecatalogue.domain.CatalogueItem;
import com.kingshuk.springbootprojects.moviecatalogue.domain.Movie;
import com.kingshuk.springbootprojects.moviecatalogue.domain.Rating;
import com.kingshuk.springbootprojects.moviecatalogue.external.ExternalAPIRequestProcessor;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
	
	@Autowired
	private ExternalAPIRequestProcessor externalProcessor;

	@GetMapping("/")
	public String hello() {
		return "Welcome to the catalogue service";
	}

	@GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CatalogueItem>> getCatalogue(@PathVariable("userId") String userId) {

		List<CatalogueItem> catalogueItems = new ArrayList<>();

		List<Rating> userRatingslist = externalProcessor.getAllUserRatings(userId);

		for (Rating rating : userRatingslist) {
			Movie movie = externalProcessor.getMovie(rating);
			catalogueItems.add(new CatalogueItem(movie.getTitle(), movie.getDescription(), rating.getMovieRating()));
		}

		return ResponseEntity.ok(catalogueItems);
	}

}
