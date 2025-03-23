package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

public class InvalidLoginParameterException extends RuntimeException {
    public InvalidLoginParameterException(String message) {
        super(message);
    }
}
