package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

public class MissingPermissionException extends RuntimeException {
    public MissingPermissionException(String message) {
        super(message);
    }
}
