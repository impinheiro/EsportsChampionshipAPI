package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class UpdateRankingCaseImpl implements UpdateRankingCase {

    private final RankingGateway rankingGateway;

    public UpdateRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public Ranking execute(String id, Ranking playerRanking) {
        return rankingGateway.update(id, playerRanking);
    }
}
