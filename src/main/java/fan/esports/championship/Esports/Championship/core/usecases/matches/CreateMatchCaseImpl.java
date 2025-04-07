package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class CreateMatchCaseImpl implements CreateMatchCase {
    private final MatchGateway matchGateway;

    public CreateMatchCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public Match execute(Match match) {
        return matchGateway.create(match);
    }
}
