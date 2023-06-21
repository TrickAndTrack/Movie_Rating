package com.movie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.Exceptions.MovieExceptions;
import com.movie.Exceptions.RatingExceptions;
import com.movie.Models.TopRatedMovieDTO;
import com.movie.Repository.RatingRepository;

@Service
public class RatingServiceImplementation implements RatingServices{

	@Autowired
	private RatingRepository rRepo;	
//	
//	@Override
//	public List<TopRatedMovieDTO> findTopRatedMovies() throws MovieExceptions, RatingExceptions {
//		// TODO Auto-generated method stub
//		List<TopRatedMovieDTO>topRatedMoviesList = rRepo.getTopRatedMovies();
//		return topRatedMoviesList;
//	}

	
	
}
