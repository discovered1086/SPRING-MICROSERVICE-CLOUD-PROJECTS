package com.kingshuk.springbootprojects.moviecatalogue.external;

import java.util.List;

import com.kingshuk.springbootprojects.moviecatalogue.domain.Movie;
import com.kingshuk.springbootprojects.moviecatalogue.domain.Rating;

public interface ExternalAPIRequestProcessor {

	List<Rating> getAllUserRatings(String userId);

	Movie getMovie(Rating rating);

}