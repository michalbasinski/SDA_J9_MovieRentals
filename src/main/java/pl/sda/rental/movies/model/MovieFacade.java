package pl.sda.rental.movies.model;

import lombok.AllArgsConstructor;
import pl.sda.rental.movies.dto.MovieDto;

@AllArgsConstructor
public class MovieFacade {

    private MovieRepository movieRepository;

    public MovieDto saveMovie(MovieDto movie) {
        return null;
    }
}
