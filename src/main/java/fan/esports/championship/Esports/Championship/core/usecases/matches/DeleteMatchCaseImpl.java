package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class DeleteMatchCaseImpl implements DeleteMatchCase {
    private final MatchGateway matchGateway;

    public DeleteMatchCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public void execute(String id) {
        matchGateway.delete(id);
    }
}
