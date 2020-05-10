package com.kingshuk.springbootprojects.moviecatalogue.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogueItem {
	
	@NonNull
	private String title;
	
	@NonNull
	private String description;
	
	private double rating;

}
