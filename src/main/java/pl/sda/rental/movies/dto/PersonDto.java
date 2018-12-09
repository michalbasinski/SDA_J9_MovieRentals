package pl.sda.rental.movies.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {
    String id;
    String name;
    String lastName;
    CountryDto country;
    String dateOfBirth;
}
