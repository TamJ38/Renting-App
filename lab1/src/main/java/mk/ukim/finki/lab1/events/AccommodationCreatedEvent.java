package mk.ukim.finki.lab1.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AccommodationCreatedEvent extends ApplicationEvent {
    public AccommodationCreatedEvent(Object source) {
        super(source);
    }
}
