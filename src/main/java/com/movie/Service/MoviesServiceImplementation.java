package com.movie.Service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.Exceptions.MovieExceptions;
import com.movie.Exceptions.RatingExceptions;
import com.movie.Models.Movies;
import com.movie.Models.longestDurationMovieDTO;
import com.movie.Models.sumVotesDTO;
import com.movie.Repository.MoviesRepository;

@Service
public class MoviesServiceImplementation implements MoviesService{
	
	@Autowired
	private MoviesRepository mRepo;



	@Override
	public List<longestDurationMovieDTO> maxDurationMovies() throws MovieExceptions {
		List<longestDurationMovieDTO> movieDTOList = mRepo.getLongestRuntimeMovies();
		return movieDTOList;
	}


	@Override
	public Movies createMovies(Movies movie) throws MovieExceptions {
		Optional<Movies> opt = mRepo.findById(movie.getTconst());
		if(opt.isEmpty())return mRepo.save(movie);
		else throw new MovieExceptions("movie already exits with the name of : "+ movie.getTconst());
		
	}

	@Override
	public void getUpdatedRuntimeMovies() throws MovieExceptions, RatingExceptions {
		mRepo.updateRuntimeMinutes();

	}

//	@Override
//	public List<sumVotesDTO> calculateVotes() throws MovieExceptions, RatingExceptions {
//		List<sumVotesDTO> votes = mRepo.findAllvotes();
//		return votes;
//	}
	


}
