package mk.ukim.finki.lab1.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AccommodationDeletedEvent extends ApplicationEvent {
    public AccommodationDeletedEvent(Object source) {
        super(source);
    }
}
