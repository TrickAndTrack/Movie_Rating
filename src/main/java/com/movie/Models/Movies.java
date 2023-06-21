package com.movie.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movies {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String tconst;
	
	private String titleType;
	
	private String primaryTitle;
	
	private Integer runtimeMinutes;
	
	private String genres;
	
	
	
}
