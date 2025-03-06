package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
