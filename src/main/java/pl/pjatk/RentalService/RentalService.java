package pl.pjatk.RentalService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;
    private final String movieServiceAddress;

    public RentalService(RestTemplate restTemplate,@Value("${service.movie.address}") String movieServiceAddress) {
        this.restTemplate = restTemplate;
        this.movieServiceAddress = movieServiceAddress;
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
}
