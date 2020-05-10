package com.kingshuk.springbootprojects.moviecatalogue.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
public class Movie {
	
	private String movieId;

	@NonNull
	private String title;
	
	@NonNull
	private String description;
}
