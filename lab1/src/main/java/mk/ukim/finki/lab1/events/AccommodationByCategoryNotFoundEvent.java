package mk.ukim.finki.lab1.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AccommodationByCategoryNotFoundEvent extends ApplicationEvent {
    public AccommodationByCategoryNotFoundEvent(Object source) {
        super(source);
    }
}
