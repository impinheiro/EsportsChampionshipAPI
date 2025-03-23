package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
