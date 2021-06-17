package pl.pjatk.RentalService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.Exception.ConnectException;
import pl.pjatk.RentalService.ExceptionHandler.RestTemplateResponseErrorHandler;

@Service
public class RentalService {

    private RestTemplate restTemplate;
    private final String movieServiceAddress;

    public RentalService(RestTemplate restTemplate, @Value("${service.movie.address}") String movieServiceAddress) {
        this.movieServiceAddress = movieServiceAddress;
        this.restTemplate = restTemplate;
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
    }

    public Movie getMovieById(Long id){
        String url = movieServiceAddress + "/movies/get/" + id;
        Movie movie = restTemplate.getForObject(url, Movie.class);
        return movie;
    }

    public void returnMovie(Long id){
        String url = movieServiceAddress + "/movies/true/" + id;
        restTemplate.put(url, null);
    }

    public void test(){
        String url = movieServiceAddress + "/movies/test";
        restTemplate.getForObject(url, Movie.class);
    }

    public void test2(){
            String url = movieServiceAddress + "/movies/test2";
            restTemplate.getForObject(url, Movie.class);
        }

    public void test3(){
        String url = movieServiceAddress + "/movies/test3";
        restTemplate.getForObject(url, Movie.class);
    }
}
