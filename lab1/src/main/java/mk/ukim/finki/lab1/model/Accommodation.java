package mk.ukim.finki.lab1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Accommodation {
    @Id
    @Column(name = "Accommodation_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @Enumerated
    public AccommodationType category;
    @ManyToOne
    public Host host;
    public Integer numRooms;
    public String isRented;

    public Accommodation() {
    }

    public Accommodation(String name, AccommodationType category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        isRented="FREE";
    }
}
