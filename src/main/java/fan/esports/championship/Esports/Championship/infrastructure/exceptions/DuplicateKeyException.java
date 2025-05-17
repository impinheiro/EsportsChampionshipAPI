package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

public class DuplicateKeyException extends RuntimeException {
    public DuplicateKeyException(String message) {
        super(message);
    }
}
