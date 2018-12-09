package pl.sda.rental.movies.model;

import lombok.AllArgsConstructor;
import pl.sda.rental.movies.dto.CountryDto;
import pl.sda.rental.movies.dto.GenreDto;
import pl.sda.rental.movies.dto.MovieDto;
import pl.sda.rental.movies.dto.PersonDto;

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

    public MovieDto dtoFromEntity(Movie movie) {
        MovieDto result = new MovieDto();

        result.setId(movie.getId().toString());
        result.setTitle(movie.getTitle());
        result.setLength(movie.getLength());
        result.setProductionDate(movie.getProductionDate());
        result.setCountryDto(CountryDto.valueOf(movie.getCountry().name()));

        List<PersonDto> directors = movie.getDirectors()
                .stream()
                .map(x -> personBuilderService.dtoFromEntity(x))
                .collect(Collectors.toList());

        List<PersonDto> cast = movie.getCast()
                .stream()
                .map(x -> personBuilderService.dtoFromEntity(x))
                .collect(Collectors.toList());

        List<GenreDto> genres = movie.getGenres()
                .stream()
                .map(x -> GenreDto.valueOf(x.name()))
                .collect(Collectors.toList());

        result.setDirectors(directors);
        result.setCast(cast);
        result.setGenres(genres);
        return result;
    }
}
