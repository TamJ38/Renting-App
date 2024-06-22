package mk.ukim.finki.lab1.Service;

import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> listHosts();
    Optional<Host> findById(Long id);

    Host create(String name,String surname, Long countryId);
    Host update(Long id, String name, String surname, Long countryId);
    public void deleteById(Long id);
}
