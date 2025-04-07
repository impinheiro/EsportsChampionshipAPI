package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class UpdateMatchCaseImpl implements  UpdateMatchCase {
    private final MatchGateway matchGateway;

    public UpdateMatchCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public Match execute(String id, Match match) {
        return matchGateway.update(id, match);
    }
}
