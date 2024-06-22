package mk.ukim.finki.lab1.Service.impl;

import mk.ukim.finki.lab1.Repository.CountryRepository;
import mk.ukim.finki.lab1.Service.CountryService;
import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab1.model.exceptions.LodgingNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
            Country country =  countryRepository.findById(id).orElseThrow(()-> new LodgingNotFoundException(id));
            return countryRepository.findById(id);
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name,continent);
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        Country country = this.findById(id).orElseThrow(()->new CountryNotFoundException(id));
        this.countryRepository.delete(country);
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country country = this.findById(id).orElseThrow(()->new CountryNotFoundException(id));
        country.setName(name);
        country.setContinent(continent);

        return this.countryRepository.save(country);
    }
}
