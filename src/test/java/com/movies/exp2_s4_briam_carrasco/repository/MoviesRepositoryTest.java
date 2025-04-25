package com.movies.exp2_s4_briam_carrasco.repository;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.movies.exp2_s4_briam_carrasco.model.Movies;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MoviesRepositoryTest {

    @Autowired
    private MoviesRepository moviesRepository;

    @Test
    public void createMovie(){
        Movies movie = new Movies();
        movie.setTitulo("Inception");
        movie.setAnio(2010L);
        movie.setDirector("Christopher Nolan");
        movie.setGenero("Sci-Fi");
        movie.setSinopsis("Un experto en robar secretos a través de los sueños debe implantar una idea en la mente de un CEO");

        Movies resultado = moviesRepository.save(movie);

        assertNotNull(resultado.getId());
        assertEquals("Inception", resultado.getTitulo());
    }

}