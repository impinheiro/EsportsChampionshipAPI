package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class DeleteTeamMatchCaseImpl implements DeleteTeamMatchCase{
    private final MatchGateway matchGateway;

    public DeleteTeamMatchCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public void execute(String id) {
        matchGateway.deleteTeamMatch(id);
    }
}
