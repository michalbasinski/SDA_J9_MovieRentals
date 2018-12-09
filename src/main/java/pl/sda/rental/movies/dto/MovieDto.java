package pl.sda.rental.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDto {
    String id;
    String title;
    int length;
    int productionDate;

    @JsonProperty("country")
    CountryDto countryDto;

    List<GenreDto> genres;
    List<PersonDto> directors;
    List<PersonDto> cast;
}
