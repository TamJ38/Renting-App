package mk.ukim.finki.lab1.Service;

import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.AccommodationType;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> listLodging();
    //public Lodging save(String name, LodgingType category, Long hostId, Integer numRooms);
    public void deleteById(Long Lodging_id);
    public Optional<Accommodation> findById(Long Lodging_id);
    public Optional<Accommodation> edit(Long Lodging_id, String name, AccommodationType category, Long hostId, Integer numRooms, String isRented);
    Accommodation create(String name, AccommodationType category, Long hostId, Integer numRooms);
    Accommodation markRented(Long id);
    public void onLodgingCreated();
    public void onLodgingEdited();
    public void onLodgingDeleted();
    public List<Accommodation> filterByCategory(String category);

    public void onLodgingByCategoryNotFound();
    public List<AccommodationType> accommodationTypes();
}
