package mk.ukim.finki.lab1.model.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Long id){
        super(String.format("Country with id %d is not found",id));
    }
}
