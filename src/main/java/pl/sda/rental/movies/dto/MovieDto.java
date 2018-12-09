package pl.sda.rental.movies.dto;

import java.util.List;

public class MovieDto {
    String id;
    String title;
    int length;
    int productionDate;
    CountryDto countryDto;
    List<GenreDto> genres;
    List<PersonDto> directors;
    List<PersonDto> cast;
}
