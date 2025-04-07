package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class CreateTeamMatchCaseImpl implements CreateTeamMatchCase {
    private final MatchGateway matchGateway;

    public CreateTeamMatchCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public TeamMatch execute(TeamMatch teamMatch) {
        return matchGateway.createTeamMatch(teamMatch);
    }
}
