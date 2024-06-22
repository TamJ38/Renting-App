package mk.ukim.finki.lab1.Service.impl;

import mk.ukim.finki.lab1.Repository.CountryRepository;
import mk.ukim.finki.lab1.Repository.HostRepository;
import mk.ukim.finki.lab1.Service.HostService;
import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.model.Host;
import mk.ukim.finki.lab1.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab1.model.exceptions.HostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Host> listHosts() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        Host host =  hostRepository.findById(id).orElseThrow(()-> new HostNotFoundException(id));
        return hostRepository.findById(id);
    }

    @Override
    public Host create(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(()-> new CountryNotFoundException(countryId));
        Host host = new Host(name,surname,country);
        return hostRepository.save(host);
    }

    @Override
    public Host update(Long id, String name, String surname, Long countryId) {
        Host host = this.findById(id).orElseThrow(()-> new HostNotFoundException(id));
        Country country = this.countryRepository.findById(countryId).orElseThrow(()-> new CountryNotFoundException(id));
        host.setName(name);
        host.setSurname(surname);
        host.setCountry(country);
        return this.hostRepository.save(host);
    }

    @Override
    public void deleteById(Long id) {
        Host host = this.findById(id).orElseThrow(()-> new HostNotFoundException(id));
        hostRepository.delete(host);
    }

}
