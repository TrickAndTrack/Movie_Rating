package com.movie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.Models.TopRatedMovieDTO;
import com.movie.Service.RatingServices;

@RestController
//@EnableCaching
@RequestMapping("api/v1")
public class RatingController {
	
	@Autowired
	private RatingServices rService;

	@CacheEvict(value = "topStories", allEntries = true)
	public void evictAllCacheValues() {
	}
	/**
	 *
	 * getting top ratted movies
	 */

//	@GetMapping("/top-rated-movies")
//	public ResponseEntity<List<TopRatedMovieDTO>> getTop10MoviesHandler(){
//		List<TopRatedMovieDTO> top10MoviesList = rService.findTopRatedMovies(); //getting movies list
//		System.out.println(top10MoviesList);
//		return new ResponseEntity<List<TopRatedMovieDTO>>(top10MoviesList,HttpStatus.OK); // returning
//	}


}
