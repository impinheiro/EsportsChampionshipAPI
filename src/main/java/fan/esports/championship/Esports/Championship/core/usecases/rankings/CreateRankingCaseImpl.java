package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class CreateRankingCaseImpl implements CreateRankingCase {

    private final RankingGateway rankingGateway;

    public CreateRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public Ranking execute(Ranking ranking) {
        return rankingGateway.createRanking(ranking);
    }
}
