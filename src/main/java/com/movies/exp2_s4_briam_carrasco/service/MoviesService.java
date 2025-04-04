package com.movies.exp2_s4_briam_carrasco.service;
import java.util.List;
import java.util.Optional;
import com.movies.exp2_s4_briam_carrasco.model.Movies;



public interface MoviesService {
    List<Movies> getAllMovies();
    Optional<Movies> getMovieById(Long id);
}
