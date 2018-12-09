package pl.sda.rental.movies.model;

import lombok.AllArgsConstructor;
import pl.sda.rental.movies.dto.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class MovieBuilderService {

    private PersonBuilderService personBuilderService;

    public Movie entityFromDto(MovieDto movieDto) {
        Movie result = new Movie();

        result.setTitle(movieDto.getTitle());
        result.setProductionDate(movieDto.getProductionDate());
        result.setLength(movieDto.getLength());

        result.setCountry(Country.valueOf(movieDto.getCountryDto().name()));
        List<Genre> genres = movieDto.getGenres()
                .stream().map(x -> Genre.valueOf(x.name())).collect(Collectors.toList());
        result.setGenres(genres);

        if (movieDto.getId() != null) {
            result.setId(Long.valueOf(movieDto.getId()));
        }

        List<Person> directors = movieDto.getDirectors().stream()
                .map(x -> personBuilderService.entityFromDto(x))
                .collect(Collectors.toList());

        List<Person> cast = movieDto.getCast().stream().
                map(x -> personBuilderService.entityFromDto(x))
                .collect(Collectors.toList());

        result.setDirectors(directors);
        result.setCast(cast);

        return result;
    }
}
