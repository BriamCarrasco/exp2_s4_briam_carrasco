package com.movies.exp2_s4_briam_carrasco.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.exp2_s4_briam_carrasco.model.Movies;
import com.movies.exp2_s4_briam_carrasco.service.MoviesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public CollectionModel<EntityModel<Movies>> getAllMovies()
    {
        List<Movies> movies = moviesService.getAllMovies();
        
        List<EntityModel<Movies>> moviesResources = movies.stream()
        .map(movie -> EntityModel.of(movie,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(movie.getId())).withSelfRel()))
                .collect(Collectors.toList());
        
        WebMvcLinkBuilder linkTO = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMovies());
        CollectionModel<EntityModel<Movies>> resources = CollectionModel.of(moviesResources, linkTO.withRel("movies"));
            
        return resources;
    }


    @GetMapping("/{id}")
    public EntityModel<Movies> getMovieById(@PathVariable long id)
    {
        Optional<Movies> movie = moviesService.getMovieById(id);
        if(movie.isPresent())
        {
            return EntityModel.of(movie.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getMovieById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllMovies()).withRel("all-movies"));
        }else
        {
            throw new MovieNotFoundException("Movie not found with id: " + id);
        }
    }
    /* 
    @GetMapping
    public List<Movies> getAllMovies() {
        return moviesService.getAllMovies();
    }
    

    @GetMapping("/{id}")
    public Optional<Movies> getMovieById(@PathVariable Long id){
        return moviesService.getMovieById(id);
    }
    */

    @PostMapping
    public Movies createMovies(@RequestBody Movies movie) {
        return moviesService.CreateMovie(movie);
    }//crear pelicula

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        moviesService.deleteMovie(id);
    }//eliminar pelicula

    @PutMapping("/{id}")
    public Movies updateMovie(@PathVariable Long id, @RequestBody Movies movie) {
        return moviesService.updateMovie(id, movie);
    }//actualizar pelicula


    

    
    
}
