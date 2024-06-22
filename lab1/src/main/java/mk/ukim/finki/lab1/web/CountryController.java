package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.Service.CountryService;
import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.model.dto.CountryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping("/add-country")
    public ResponseEntity<Void> addCountry(@RequestBody CountryDto countryDTO) {
        if(countryDTO == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.create(countryDTO.getName(), countryDTO.getContinent());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return this.service.listAll();
    }
}
