package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class UpdateTeamMatchCaseImpl implements UpdateTeamMatchCase {
    private final MatchGateway matchGateway;

    public UpdateTeamMatchCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public TeamMatch execute(String id, TeamMatch teamMatch) {
        return matchGateway.updateTeamMatch(id, teamMatch);
    }
}
