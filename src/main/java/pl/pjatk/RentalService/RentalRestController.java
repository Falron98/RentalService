package pl.pjatk.RentalService;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/rental/")
public class RentalRestController {

    private final RentalService rentalService;

    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable("id") Long id){
        return rentalService.getMovieById(id);
    }

    @GetMapping("true/{id}")
    public void returnMovie(@PathVariable("id") Long id){
        rentalService.returnMovie(id);
    }

}
