package mk.ukim.finki.lab1.Service;

import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.model.exceptions.LodgingNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public Optional<Country> findById(Long id);
    List<Country> listAll();
    Country create(String name,String continent);
    void deleteById(Long id);
    Country update(Long id, String name, String continent);

}
