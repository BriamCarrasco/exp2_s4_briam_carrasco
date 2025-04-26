package com.movies.exp2_s4_briam_carrasco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.movies.exp2_s4_briam_carrasco.model.Movies;
import com.movies.exp2_s4_briam_carrasco.repository.MoviesRepository;

@ExtendWith(MockitoExtension.class)
public class MoviesServiceTest {

    @InjectMocks
    private MoviesServiceImpl moviesServiceImpl;

    @Mock
    private MoviesRepository moviesRepositoryMock;
    
    private Movies movies;

    @BeforeEach
    void setUp() {
        movies = new Movies();
        movies.setTitulo("Shrek");
        movies.setAnio(2001L);
        movies.setDirector("Andrew Adamson");
        movies.setGenero("Animacion/comedia");
        movies.setSinopsis("Un ogro llamado Shrek debe rescatar a una princesa para recuperar la paz de su pantano");
    }

    @AfterEach
    void tearDown() {
        movies = null;
    }


    @Test
    public void createMovieTest(){
       
        when(moviesRepositoryMock.save(any())).thenReturn(movies);

        Movies resultado = moviesServiceImpl.CreateMovie(movies);

        assertEquals("Shrek", resultado.getTitulo());
        
    }

    @Test
    public void updateMovieTest() {
        Long movieId = 1L;

        when(moviesRepositoryMock.existsById(movieId)).thenReturn(true);
        when(moviesRepositoryMock.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Movies result = moviesServiceImpl.updateMovie(movieId, movies);

        assertNotNull(result);
        assertEquals(movieId, result.getId());
        assertEquals("Shrek", result.getTitulo());
        assertEquals(2001L, result.getAnio());
        assertEquals("Andrew Adamson", result.getDirector());
        assertEquals("Animacion/comedia", result.getGenero());
        assertEquals("Un ogro llamado Shrek debe rescatar a una princesa para recuperar la paz de su pantano", result.getSinopsis());
    }

    
}
