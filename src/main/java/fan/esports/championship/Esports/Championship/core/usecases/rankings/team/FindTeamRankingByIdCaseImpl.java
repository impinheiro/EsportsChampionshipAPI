package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class FindTeamRankingByIdCaseImpl implements FindTeamRankingByIdCase {

    private final RankingGateway rankingGateway;

    public FindTeamRankingByIdCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public TeamRanking execute(String id) {
        return rankingGateway.findTeamRankingById(id);
    }
}
