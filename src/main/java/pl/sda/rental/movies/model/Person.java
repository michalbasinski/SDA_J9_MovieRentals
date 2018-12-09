package pl.sda.rental.movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONS")
@Getter
@Setter
class Person {
    String id;
    String name;
    String lastName;
    Country country;
    String dateOfBirth;
}
