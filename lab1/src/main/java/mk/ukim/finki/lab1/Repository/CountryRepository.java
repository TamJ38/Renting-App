package mk.ukim.finki.lab1.Repository;

import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
