package pl.pjatk.RentalService.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.ExceptionHandler.RestTemplateResponseErrorHandler;
import pl.pjatk.RentalService.Movie;

@Service
@Configuration
public class BeanConfig {

    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    @Bean
    public Movie movie(){
        Movie movie = new Movie();
        return movie;
    }

}
