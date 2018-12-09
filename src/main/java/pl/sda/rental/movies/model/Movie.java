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
@Table(name = "MOVIES")
@Getter
@Setter
class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int length;
    private int productionDate;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "MOVIE_DIRECTORS")
    List<Person> directors;

    @ManyToMany
    @JoinTable(name = "MOVIE_CAST")
    List<Person> cast;
}
