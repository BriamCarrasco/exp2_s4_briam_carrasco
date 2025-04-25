package com.movies.exp2_s4_briam_carrasco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    
    @Test
    public void createMovieTest(){
        Movies movies = new Movies();
        movies.setTitulo("Inception");
        movies.setAnio(2010L);
        movies.setDirector("Christopher Nolan");
        movies.setGenero("Sci-Fi");
        movies.setSinopsis("Un experto en robar secretos a través de los sueños debe implantar una idea en la mente de un CEO");
        

        when(moviesRepositoryMock.save(any())).thenReturn(movies);

        Movies resultado = moviesServiceImpl.CreateMovie(movies);

        assertEquals("Inception", resultado.getTitulo());
        
    }
    
}
