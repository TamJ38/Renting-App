package mk.ukim.finki.lab1.model.exceptions;

public class LodgingNotFoundException extends RuntimeException{
    public LodgingNotFoundException(Long id){
        super(String.format("Lodging with id %d was not found", id));
    }
}
