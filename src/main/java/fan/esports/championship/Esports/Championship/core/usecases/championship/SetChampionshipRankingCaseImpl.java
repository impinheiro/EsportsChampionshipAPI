package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

public class SetChampionshipRankingCaseImpl implements SetChampionshipRankingCase {

    private final ChampionshipGateway championshipGateway;

    public SetChampionshipRankingCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public void execute(String championshipId, String rankingId) {
        championshipGateway.setRanking(championshipId, rankingId);
    }
}
