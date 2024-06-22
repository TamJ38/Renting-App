package mk.ukim.finki.lab1.listeners;

import mk.ukim.finki.lab1.Service.AccommodationService;
import mk.ukim.finki.lab1.events.AccommodationByCategoryNotFoundEvent;
import mk.ukim.finki.lab1.events.AccommodationCreatedEvent;
import mk.ukim.finki.lab1.events.AccommodationDeletedEvent;
import mk.ukim.finki.lab1.events.AccommodationEditedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccommodationEventListener {
    private final AccommodationService accommodationService;

    public AccommodationEventListener(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }
    @EventListener
    public void onLodgingCreated(AccommodationCreatedEvent event){
        this.accommodationService.onLodgingCreated();
    }
    @EventListener
    public void onLodgingDeleted(AccommodationDeletedEvent event) {
        this.accommodationService.onLodgingDeleted();
    }

    @EventListener
    public void onLodgingEdited(AccommodationEditedEvent event) {
        this.accommodationService.onLodgingEdited();
    }
    @EventListener
    public void onLodgingByCategoryNotFound(AccommodationByCategoryNotFoundEvent event){this.accommodationService.onLodgingByCategoryNotFound();}
}
