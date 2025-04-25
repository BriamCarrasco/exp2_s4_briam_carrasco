package com.movies.exp2_s4_briam_carrasco.controller;

import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.movies.exp2_s4_briam_carrasco.model.Movies;
import com.movies.exp2_s4_briam_carrasco.service.MoviesServiceImpl;

@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MoviesServiceImpl moviesServiceMock;

    /* 
    @Test
    public void obtenerTodasLasPeliculasTest() throws Exception {
        Movies movie1 = new Movies();
        movie1.setId(1L);
        movie1.setTitulo("Inception");
        movie1.setAnio(2010L);
        movie1.setDirector("Christopher Nolan");
        movie1.setGenero("Sci-Fi");
        movie1.setSinopsis("A mind-bending thriller");

        Movies movie2 = new Movies();
        movie2.setId(2L);
        movie2.setTitulo("Interstellar");
        movie2.setAnio(2014L);
        movie2.setDirector("Christopher Nolan");
        movie2.setGenero("Sci-Fi");
        movie2.setSinopsis("Space exploration for survival");

    List<Movies> movies = Arrays.asList(movie1, movie2);
    when(moviesServiceMock.getAllMovies()).thenReturn(movies);

    mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(6)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].titulo").value("Inception"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].anio").value(2010L))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].director").value("Christopher Nolan"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].genero").value("Sci-Fi"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].sinopsis").value("A mind-bending thriller"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].titulo").value("Interstellar"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].anio").value(2014L))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].director").value("Christopher Nolan"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].genero").value("Sci-Fi"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].sinopsis").value("Space exploration for survival"));
    }
    */

    @Test
    public void obtenerTodasLasPeliculasTest() throws Exception 
    {
        Movies movie1 = new Movies();
        movie1.setId(1L);
        movie1.setTitulo("Inception");
        movie1.setAnio(2010L);
        movie1.setDirector("Christopher Nolan");
        movie1.setGenero("Sci-Fi");
        movie1.setSinopsis("A mind-bending thriller");

        Movies movie2 = new Movies();
        movie2.setId(2L);
        movie2.setTitulo("Interstellar");
        movie2.setAnio(2014L);
        movie2.setDirector("Christopher Nolan");
        movie2.setGenero("Sci-Fi");
        movie2.setSinopsis("Space exploration for survival");

        List<Movies> movies = Arrays.asList(movie1, movie2);
        when(moviesServiceMock.getAllMovies()).thenReturn(movies);      

        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[0].titulo").value("Inception"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[0].anio").value(2010L))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[0].director").value("Christopher Nolan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[0].genero").value("Sci-Fi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[0].sinopsis").value("A mind-bending thriller"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[1].titulo").value("Interstellar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[1].anio").value(2014L))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[1].director").value("Christopher Nolan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[1].genero").value("Sci-Fi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.moviesList[1].sinopsis").value("Space exploration for survival"));
    }
}
