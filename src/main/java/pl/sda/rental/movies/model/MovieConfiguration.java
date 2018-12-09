package pl.sda.rental.movies.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MovieConfiguration {

    @Bean
    MovieFacade movieFacade(MovieRepository movieRepository, MovieBuilderService movieBuilderService) {
        return new MovieFacade(movieRepository, movieBuilderService);
    }

    @Bean
    MovieBuilderService movieBuilderService(PersonBuilderService personBuilderService) {
        return new MovieBuilderService(personBuilderService);
    }

    @Bean
    PersonBuilderService personBuilderService() {
        return new PersonBuilderService();
    }

}
