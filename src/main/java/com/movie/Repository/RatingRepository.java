package com.movie.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.Exceptions.MovieExceptions;
import com.movie.Exceptions.RatingExceptions;
import com.movie.Models.Ratings;
import com.movie.Models.TopRatedMovieDTO;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, String>{
	
//	//	jpql
//		//top rated movies
//		@Query("select new com.movie.Models.TopRatedMovieDTO(m.tconst,m.primaryTitle,m.genres,r.averageRating) from Movies m INNER JOIN Ratings r ON m.tconst = r.tconst where r.averageRating >= 6")
//		List<TopRatedMovieDTO> getTopRatedMovies();
	

}
