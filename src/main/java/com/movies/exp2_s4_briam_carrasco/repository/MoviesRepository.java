package com.movies.exp2_s4_briam_carrasco.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.movies.exp2_s4_briam_carrasco.model.Movies;


public interface MoviesRepository extends JpaRepository<Movies, Long> {
    
}
