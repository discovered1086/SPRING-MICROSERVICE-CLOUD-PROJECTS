package com.kingshuk.springbootprojects.movieinfo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieSummary {
	
	private String id;
	
    private String title;
    
    private String overview;
}
