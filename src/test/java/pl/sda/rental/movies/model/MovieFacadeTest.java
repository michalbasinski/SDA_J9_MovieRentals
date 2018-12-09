package pl.sda.rental.movies.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.rental.RentalApplication;
import pl.sda.rental.movies.dto.CountryDto;
import pl.sda.rental.movies.dto.GenreDto;
import pl.sda.rental.movies.dto.MovieDto;
import pl.sda.rental.movies.dto.PersonDto;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RentalApplication.class)
public class MovieFacadeTest {

    @MockBean
    private MovieRepository movieRepository;

    @Autowired
    private MovieFacade movieFacade;

    @Before
    public void shouldSaveMovie() {
        Movie movie = prepareTestMovie();
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        Optional<Movie> returnedMovie = Optional.of(movie);
        when(movieRepository.findById(anyLong())).thenReturn(returnedMovie);
    }

    @Test
    public void shouldGetMovie() {
        //given
        MovieDto movieDto = prepareDto();
        final String expectedDirectorName = "Charlie";
        final String expecedTitle = "Test movie";
        final CountryDto expectedCountry = CountryDto.GB;

        //when
        MovieDto result = movieFacade.saveMovie(movieDto);

        //then
        assertEquals(expectedDirectorName, result.getDirectors().get(0).getName());
        assertEquals(expecedTitle, result.getTitle());
        assertEquals(expectedCountry, result.getCountryDto());
    }

    @Test
    public void getMovie() {
        final String expectedDirectorName = "Charlie";
        final String expecedTitle = "Test movie";
        final CountryDto expectedCountry = CountryDto.GB;

        //when
        MovieDto result = movieFacade.getMovie(1l);

        //then
        assertEquals(expectedDirectorName, result.getDirectors().get(0).getName());
        assertEquals(expecedTitle, result.getTitle());
        assertEquals(expectedCountry, result.getCountryDto());

    }

    private Movie prepareTestMovie() {
        Movie result = new Movie();

        result.setId(1l);
        result.setTitle("Test movie");
        result.setCountry(Country.GB);
        result.setLength(99);
        result.setProductionDate(2000);
        result.setGenres(Arrays.asList(Genre.ACTION, Genre.COMEDY));

        Person person = new Person();
        person.setId(1l);
        person.setDateOfBirth("01-01-1900");
        person.setName("Charlie");
        person.setLastName("Chaplin");
        person.setCountry(Country.GB);
        result.setDirectors(Arrays.asList(person));

        Person actor = new Person();
        actor.setId(2l);
        actor.setDateOfBirth("02-02-1901");
        actor.setName("Hans");
        actor.setLastName("Gruber");
        actor.setCountry(Country.DE);
        result.setCast(Arrays.asList(actor));

        return result;
    }

    private MovieDto prepareDto() {
        MovieDto result = new MovieDto();

        result.setTitle("Test movie");
        result.setCountryDto(CountryDto.GB);
        result.setLength(99);
        result.setProductionDate(2000);
        result.setGenres(Arrays.asList(GenreDto.ACTION, GenreDto.COMEDY));

        PersonDto person = new PersonDto();
        person.setDateOfBirth("01-01-1900");
        person.setName("Charlie");
        person.setLastName("Chaplin");
        person.setCountry(CountryDto.GB);
        result.setDirectors(Arrays.asList(person));

        PersonDto actor = new PersonDto();
        actor.setDateOfBirth("02-02-1901");
        actor.setName("Hans");
        actor.setLastName("Gruber");
        actor.setCountry(CountryDto.DE);
        result.setCast(Arrays.asList(actor));

        return result;
    }
}