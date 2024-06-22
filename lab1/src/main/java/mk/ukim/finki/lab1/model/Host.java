package mk.ukim.finki.lab1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Host {
    @Id
    @Column(name = "Host_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String surname;
    @ManyToOne
    public Country country;

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Host() {
    }
}
