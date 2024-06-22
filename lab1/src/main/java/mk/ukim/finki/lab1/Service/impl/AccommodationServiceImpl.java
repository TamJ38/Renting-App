package mk.ukim.finki.lab1.Service.impl;

import mk.ukim.finki.lab1.Repository.HostRepository;
import mk.ukim.finki.lab1.Repository.AccommodationRepository;
import mk.ukim.finki.lab1.Service.AccommodationService;
import mk.ukim.finki.lab1.events.AccommodationByCategoryNotFoundEvent;
import mk.ukim.finki.lab1.events.AccommodationCreatedEvent;
import mk.ukim.finki.lab1.events.AccommodationDeletedEvent;
import mk.ukim.finki.lab1.events.AccommodationEditedEvent;
import mk.ukim.finki.lab1.model.Host;
import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.AccommodationType;
import mk.ukim.finki.lab1.model.exceptions.HostNotFoundException;
import mk.ukim.finki.lab1.model.exceptions.LodgingNotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostRepository hostRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Accommodation> listLodging() {
        return accommodationRepository.findAll();
    }


    @Override
    public void deleteById(Long Lodging_id) {
        Accommodation accommodation = accommodationRepository.findById(Lodging_id).orElseThrow(() -> new LodgingNotFoundException(Lodging_id));
        accommodationRepository.delete(accommodation);
        this.applicationEventPublisher.publishEvent(new AccommodationDeletedEvent(accommodation));
    }

    @Override
    public Optional<Accommodation> findById(Long Lodging_id) {
        Accommodation book = accommodationRepository.findById(Lodging_id).orElseThrow(() -> new LodgingNotFoundException(Lodging_id));
        return accommodationRepository.findById(Lodging_id);
    }

    @Override
    public Optional<Accommodation> edit(Long Lodging_id, String name, AccommodationType category, Long hostId, Integer numRooms, String isRented) {
        Accommodation accommodation = accommodationRepository.findById(Lodging_id).orElseThrow(() -> new LodgingNotFoundException(Lodging_id));
        Host host = hostRepository.findById(hostId).orElseThrow(() -> new HostNotFoundException(hostId));
        accommodation.setName(name);
        accommodation.setCategory(category);
        accommodation.setNumRooms(numRooms);
        accommodation.setHost(host);
        accommodation.setIsRented(isRented);
        accommodationRepository.save(accommodation);
        this.applicationEventPublisher.publishEvent(new AccommodationEditedEvent(accommodation));
        return Optional.of(accommodation);
    }

    @Override
    public Accommodation create(String name, AccommodationType category, Long hostId, Integer numRooms) {
        Host host = hostRepository.findById(hostId).orElseThrow(() -> new HostNotFoundException(hostId));
        Accommodation accommodation = new Accommodation(name, category, host, numRooms);
        this.applicationEventPublisher.publishEvent(new AccommodationCreatedEvent(accommodation));
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation markRented(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(() -> new LodgingNotFoundException(id));
        accommodation.setIsRented("RENTED");
        accommodationRepository.save(accommodation);
        return accommodation;
    }

    @Override
    public void onLodgingCreated() {
        System.out.println("[CREATE]: Lodging created successfully");
    }

    @Override
    public void onLodgingEdited() {
        System.out.println("[EDIT]: Lodging edited successfully");
    }

    @Override
    public void onLodgingDeleted() {
        System.out.println("[DELETE]: Lodging deleted successfully");
    }

     @Override
    public List<Accommodation> filterByCategory(String category) {
        List<Accommodation> accommodations = accommodationRepository.findAllByCategory(AccommodationType.valueOf(category));
        if(accommodations.isEmpty()){
            this.applicationEventPublisher.publishEvent(new AccommodationByCategoryNotFoundEvent(accommodations));
        }
        return accommodations;
    }

    @Override
    public void onLodgingByCategoryNotFound() {
        System.out.println("[NOT FOUND]: Lodging with that category is not found");
    }

    @Override
    public List<AccommodationType> accommodationTypes() {
        return List.of(AccommodationType.values());
    }


}