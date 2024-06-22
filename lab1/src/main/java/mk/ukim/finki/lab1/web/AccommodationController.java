package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.Service.HostService;
import mk.ukim.finki.lab1.Service.AccommodationService;
import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.dto.AccommodationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationController(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addLodging(@RequestBody AccommodationDto accommodationDto) {
        if(accommodationDto == null) {
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(accommodationDto.getHost()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.accommodationService.create(accommodationDto.getName(), accommodationDto.getCategory(), accommodationDto.getHost(), accommodationDto.getNumRooms());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLodging(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        if(accommodationService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.accommodationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editLodging(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto) {
        if(accommodationDto == null) {
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(accommodationDto.getHost()) == null || accommodationService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.accommodationService.edit(id, accommodationDto.getName(), accommodationDto.getCategory(), accommodationDto.getHost(), accommodationDto.getNumRooms(), accommodationDto.getIsRented());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mark/{id}")
    public ResponseEntity<Void> markBook(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        if(accommodationService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        this.accommodationService.markRented(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Accommodation> getLodgings() {
        return this.accommodationService.listLodging();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        return this.accommodationService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/filter")
    public List<Accommodation> filterLodgingsByCategory(@RequestParam String category) {

        return accommodationService.filterByCategory(category);

    }

}
