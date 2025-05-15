package fan.esports.championship.Esports.Championship.core.usecases.rankings.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

import java.util.List;

public class FindPlayerRankingsCaseImpl implements FindPlayerRankingsCase {

    private final RankingGateway rankingGateway;

    public FindPlayerRankingsCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public List<PlayerRanking> execute() {
        return rankingGateway.findAllPlayerRankings();
    }
}
