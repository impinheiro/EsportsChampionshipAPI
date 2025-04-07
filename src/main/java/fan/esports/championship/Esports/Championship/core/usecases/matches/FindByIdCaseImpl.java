package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class FindByIdCaseImpl implements FindByIdCase {
    private final MatchGateway matchGateway;

    public FindByIdCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public Match execute(String id) {
        return  matchGateway.findById(id);
    }
}
