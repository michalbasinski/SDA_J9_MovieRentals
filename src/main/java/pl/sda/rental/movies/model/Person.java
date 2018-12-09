package pl.sda.rental.movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PERSONS")
@Getter
@Setter
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;

    @Enumerated(EnumType.STRING)
    Country country;

    String dateOfBirth;

    @ManyToMany(mappedBy = "directors")
    List<Movie> directedMovies;

    @ManyToMany(mappedBy = "cast")
    List<Movie> starredMovies;
}
