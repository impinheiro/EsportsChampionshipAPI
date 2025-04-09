package fan.esports.championship.Esports.Championship.infrastructure.exceptions;

public class MatchNotFoundEx extends RuntimeException {
    public MatchNotFoundEx(String message) {
        super(message);
    }
}
