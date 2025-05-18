package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.MatchNotFoundException;

public class SubscribeMatchCaseImpl implements SubscribeMatchCase {
    private final ChampionshipGateway championshipGateway;
    private final MatchGateway matchGateway;

    public SubscribeMatchCaseImpl(ChampionshipGateway championshipGateway, MatchGateway matchGateway) {
        this.championshipGateway = championshipGateway;
        this.matchGateway = matchGateway;
    }

    @Override
    public Championship execute(String championshipId, String matchId) {
        if(!matchGateway.findById(matchId).isPresent()) {
            throw new MatchNotFoundException("There is no such match in our database");
        }
        return championshipGateway.subscribeMatch(championshipId, matchId);
    }
}
