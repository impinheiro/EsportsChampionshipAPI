package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

import java.util.List;

public class FindAllTeamMatchesCaseImpl implements  FindAllTeamMatchesCase {
    private final MatchGateway matchGateway;

    public FindAllTeamMatchesCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public List<TeamMatch> execute() {
        return matchGateway.findAllTeamMatches();
    }
}
