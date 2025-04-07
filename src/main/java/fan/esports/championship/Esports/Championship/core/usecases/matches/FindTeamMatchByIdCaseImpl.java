package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class FindTeamMatchByIdCaseImpl implements FindTeamMatchByIdCase{
    private final MatchGateway matchGateway;

    public FindTeamMatchByIdCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public TeamMatch execute(String id) {
        return matchGateway.findTeamMatchById(id).orElse(null);
    }
}
