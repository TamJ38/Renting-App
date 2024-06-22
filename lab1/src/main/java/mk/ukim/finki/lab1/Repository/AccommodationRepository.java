package mk.ukim.finki.lab1.Repository;

import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.AccommodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
    public List<Accommodation> findAllByCategory(AccommodationType category);
}
