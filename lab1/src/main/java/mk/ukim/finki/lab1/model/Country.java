package mk.ukim.finki.lab1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Country {
    @Id
    @Column(name = "Country_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String continent;

    public Country(String name, String continent){
        this.name=name;
        this.continent=continent;
    }
    public Country(){}
}
