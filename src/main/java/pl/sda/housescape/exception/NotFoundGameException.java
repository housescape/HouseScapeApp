package pl.sda.housescape.exception;

public class NotFoundGameException extends WebApplicationException {

    public NotFoundGameException(String message){
        super(message);
    }
}