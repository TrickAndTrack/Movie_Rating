package com.movie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.Models.Movies;
import com.movie.Models.longestDurationMovieDTO;
import com.movie.Models.sumVotesDTO;
import com.movie.Repository.MoviesRepository;
import com.movie.Service.MoviesService;





@RestController
@EnableCaching
@RequestMapping("api/v1")
public class MoviesController {
	
	@Autowired
	private MoviesService mServices;
	
	@Autowired
	private MoviesRepository mrepo;

	@CacheEvict(value = "topStories", allEntries = true)
	public void evictAllCacheValues() {
	}

	/**
	 *
	 * @param mv object
	 * @return register movies Object with succesfull message
	 */
	@CachePut(value = "movie", key = "#movie.tconst")
	@PostMapping("/new-movie")
	public ResponseEntity<String> registerMovieHandler(@RequestBody Movies mv){
		Movies movie = mServices.createMovies(mv);
		String str = movie+" : movie successfuly register ";
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}

	/**
	 *
	 * @return returning movies longest-duration-movies
	 */
	@Cacheable(value = "movies")
	@GetMapping("/longest-duration-movies")
	public ResponseEntity<List<longestDurationMovieDTO>> getTop10MoviesHandler(){
		List<longestDurationMovieDTO> top10MoviesList = mServices.maxDurationMovies();
		return new ResponseEntity<List<longestDurationMovieDTO>>(top10MoviesList,HttpStatus.OK);
	}


	/**
	 *
	 * @return update-runtime-minutes
	 * ipdating the runtime minutes
	 */


	@Cacheable(value = "movies")
	@GetMapping("/update-runtime-minutes")
	public ResponseEntity<List<Movies>> updateRuntimeHandler(){
		mServices.getUpdatedRuntimeMovies();
		List<Movies> mvList = mrepo.findAll();
		
		return new ResponseEntity<List<Movies>>(mvList,HttpStatus.OK);
	}

	/**
	 *
	 *
	 * @return genre-movies-with-subtotals
	 */
//	@GetMapping("/genre-movies-with-subtotals")
//	public ResponseEntity<List<sumVotesDTO>> getVotesHandler(){
//		List<sumVotesDTO> top10MoviesList = mServices.calculateVotes();
//		return new ResponseEntity<List<sumVotesDTO>>(top10MoviesList,HttpStatus.OK);
//	}
	
}
