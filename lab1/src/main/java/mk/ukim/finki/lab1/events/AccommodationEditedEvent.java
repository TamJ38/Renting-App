package mk.ukim.finki.lab1.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AccommodationEditedEvent extends ApplicationEvent {

    public AccommodationEditedEvent(Object source) {
        super(source);
    }
}
