package mk.ukim.finki.lab1.model.dto;

import lombok.Data;
import mk.ukim.finki.lab1.model.Country;

@Data
public class HostDto {
    public String name;
    public String surname;
    public Long countryId;


}
