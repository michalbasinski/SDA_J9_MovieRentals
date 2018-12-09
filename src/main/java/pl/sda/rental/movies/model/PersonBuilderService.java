package pl.sda.rental.movies.model;

import pl.sda.rental.movies.dto.PersonDto;

public class PersonBuilderService {

    public Person entityFromDto(PersonDto personDto) {
        Person person = new Person();

        if (personDto.getId() != null) {
            person.setId(Long.valueOf(personDto.getId()));
        }
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        person.setCountry(Country.valueOf(personDto.getCountry().name()));
        person.setDateOfBirth(personDto.getDateOfBirth());
        return person;
    }

}
