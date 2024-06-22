package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.Service.CountryService;
import mk.ukim.finki.lab1.Service.HostService;
import mk.ukim.finki.lab1.model.Host;
import mk.ukim.finki.lab1.model.dto.HostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api")
public class HostController {
    private final HostService hostService;
    private final CountryService countryService;

    public HostController(HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }
    @PostMapping("/add-host")
    public ResponseEntity<Void> addHost(@RequestBody HostDto hostDto) {
        if(hostDto == null) {
            return ResponseEntity.notFound().build();
        }

        if(countryService.findById(hostDto.getCountryId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.hostService.create(hostDto.getName(), hostDto.getSurname(), hostDto.getCountryId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hosts")
    public List<Host> getHosts() {
        return this.hostService.listHosts();
    }

    @PostMapping("/delete-hosts/{id}")
    public ResponseEntity<Void> getAuthors(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        this.hostService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}