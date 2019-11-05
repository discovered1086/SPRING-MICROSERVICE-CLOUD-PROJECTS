package com.kingshuk.springbootprojects.moviecatalogue.domain;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {

	private String userId;
	private List<Rating> ratings;

	public void initData(String userId) {
		this.setUserId(userId);
		this.setRatings(Arrays.asList(new Rating(100, 3.00), new Rating(200, 4.00)));
	}
}
