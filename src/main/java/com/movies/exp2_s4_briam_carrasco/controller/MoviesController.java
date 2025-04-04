package com.movies.exp2_s4_briam_carrasco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.exp2_s4_briam_carrasco.model.Movies;
import com.movies.exp2_s4_briam_carrasco.service.MoviesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public List<Movies> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movies> getMovieById(@PathVariable Long id){
        return moviesService.getMovieById(id);
    }
    
    
}
