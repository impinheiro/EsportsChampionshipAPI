package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

import java.util.List;

public class FindAllRankingsCaseImpl implements FindAllRankingsCase {

    private final RankingGateway rankingGateway;

    public FindAllRankingsCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public List<Ranking> execute() {
        return rankingGateway.findAll();
    }
}
