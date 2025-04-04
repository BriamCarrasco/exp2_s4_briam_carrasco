package com.movies.exp2_s4_briam_carrasco.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movies.exp2_s4_briam_carrasco.model.Movies;
import com.movies.exp2_s4_briam_carrasco.repository.MoviesRepository;



@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;
    
    @Override
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Optional<Movies> getMovieById(Long id) {
        return moviesRepository.findById(id);
    }
    
}
