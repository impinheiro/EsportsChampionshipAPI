package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

import java.util.List;

public class FindAllMatchesCaseImpl implements  FindAllMatchesCase {
    private final MatchGateway matchGateway;

    public FindAllMatchesCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public List<Match> execute() {
        return matchGateway.findAll();
    }
}
