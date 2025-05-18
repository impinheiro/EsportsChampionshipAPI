package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class FindRankingByIdCaseImpl implements FindRankingByIdCase {

    private final RankingGateway rankingGateway;

    public FindRankingByIdCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public Ranking execute(String id) {
        return rankingGateway.findById(id).orElse(null);
    }
}
