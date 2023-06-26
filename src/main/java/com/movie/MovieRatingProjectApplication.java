package com.movie;

import com.movie.Controller.MoviesController;
import com.movie.Controller.RatingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;

import java.util.logging.Logger;

@SpringBootApplication
@EnableCaching
public class MovieRatingProjectApplication {


	public static void main(String[] args) {
		Logger logger = Logger.getLogger(String.valueOf(MovieRatingProjectApplication.class));
		SpringApplication.run(MovieRatingProjectApplication.class, args);
		new MoviesController().evictAllCacheValues();
		new RatingController().evictAllCacheValues();
		logger.info("Cache cleared!!!");
	}

}

