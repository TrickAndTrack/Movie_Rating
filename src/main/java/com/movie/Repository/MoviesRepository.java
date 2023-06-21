package com.movie.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.Exceptions.MovieExceptions;
import com.movie.Models.Movies;
import com.movie.Models.longestDurationMovieDTO;
import com.movie.Models.sumVotesDTO;

import jakarta.transaction.Transactional;



@Repository
public interface MoviesRepository extends JpaRepository<Movies, String>{
	
	 //jpql
	 //top 10 movie with logest runtime duration
	 @Query("select new com.movie.Models.longestDurationMovieDTO(m.tconst,m.primaryTitle,m.runtimeMinutes,m.genres) from Movies m order by runtimeMinutes DESC LIMIT 10")
	 List<longestDurationMovieDTO> getLongestRuntimeMovies();
	 
	 
	//sql
	//updating the runtime minutes based on the genres
	@Modifying
	@Transactional
	@Query(value="Update Movies set runtime_Minutes = CASE WHEN genres = 'Documentary' THEN runtime_minutes+15 WHEN genres = 'Animation' THEN runtime_minutes+30 ELSE runtime_Minutes+45 END",nativeQuery = true)
	void updateRuntimeMinutes(); 
	
	 @Query("SELECT  m.genres, m.primary_Title, SUM(r.numVotes) FROM Movies m INNER JOIN Ratings r ON m.tconst = r.tconst GROUP BY m.genres, m.primary_Title")	
	 List<sumVotesDTO> findAllvotes();
	 
	 
}


//select new com.onito.Models.sumVotesDTO(m.genres,m.primaryTitle,SUM(r.numVotes)) from Movies m INNER JOIN Ratings r ON m.tconst = r.tconst group by m.primaryTitle

	 // SELECT SUM(r.numVotes) AS total_sum, r.tconst FROM Movies m INNER JOIN Ratings r ON m.tconst = r.tconst GROUP BY m.primaryTitle
	 
	 
