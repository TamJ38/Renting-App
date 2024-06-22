package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.Service.AccommodationService;
import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.AccommodationType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api")
public class CategoriesController {
    private final AccommodationService accommodationService;

    public CategoriesController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }
    @GetMapping("/categories")
    public List<AccommodationType> getAccommodationTypes() {
        return this.accommodationService.accommodationTypes();
    }
}
