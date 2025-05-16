package fan.esports.championship.Esports.Championship.core.usecases.rankings.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class FindPlayerRankingByIdCaseImpl implements FindPlayerRankingByIdCase {

    private final RankingGateway rankingGateway;

    public FindPlayerRankingByIdCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public PlayerRanking execute(String id) {
        return rankingGateway.findPlayerRankingById(id).orElse(null);
    }
}
