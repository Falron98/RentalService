package pl.pjatk.RentalService.RestController;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RentalService.Movie;
import pl.pjatk.RentalService.Service.RentalService;

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

    @GetMapping("test")
    public void test(){
        rentalService.test();
    }

    @GetMapping("test2")
    public void test2(){
            rentalService.test2();
    }

    @GetMapping("test3")
    public void test3(){
        rentalService.test3();
    }
}
