package com.movie.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@RedisHash("Ratings")
public class Ratings implements Serializable {
	
	@Id
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Movies tconst;
	
	private Double averageRating;
	
	private Integer numVotes;

}
