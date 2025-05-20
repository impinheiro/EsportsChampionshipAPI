package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class SetMatchChampionshipIdCaseImpl implements SetMatchChampionshipIdCase {

    private final MatchGateway matchGateway;

    public SetMatchChampionshipIdCaseImpl(MatchGateway matchGateway) {
        this.matchGateway = matchGateway;
    }

    @Override
    public void execute(String matchId, String championshipId) {
        matchGateway.setChampionshipId(matchId, championshipId);
    }
}
