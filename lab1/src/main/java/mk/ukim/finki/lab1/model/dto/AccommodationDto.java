package mk.ukim.finki.lab1.model.dto;

import lombok.Data;
import mk.ukim.finki.lab1.model.AccommodationType;

@Data
public class AccommodationDto {
    public String name;
    public AccommodationType category;
    public Long host;
    public Integer numRooms;
    public String isRented;


}
