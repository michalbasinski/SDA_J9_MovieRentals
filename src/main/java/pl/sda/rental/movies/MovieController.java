package pl.sda.rental.movies;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.rental.movies.dto.MovieDto;
import pl.sda.rental.movies.model.MovieFacade;

@RestController
@AllArgsConstructor
public class MovieController {

    private MovieFacade movieFacade;

    @PostMapping("/movies")
    public ResponseEntity addPost(@RequestBody MovieDto movieDto) {
        MovieDto result = movieFacade.saveMovie(movieDto);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
