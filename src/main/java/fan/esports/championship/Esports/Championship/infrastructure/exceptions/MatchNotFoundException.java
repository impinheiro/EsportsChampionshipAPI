package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

public class MatchNotFoundException extends RuntimeException {
    public MatchNotFoundException(String message) {
        super(message);
    }
}
