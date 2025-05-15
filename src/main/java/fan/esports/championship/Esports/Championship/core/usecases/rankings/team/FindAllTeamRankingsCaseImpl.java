package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

import java.util.List;

public class FindAllTeamRankingsCaseImpl implements FindAllTeamRankingsCase {

    private final RankingGateway rankingGateway;

    public FindAllTeamRankingsCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public List<TeamRanking> execute() {
        return rankingGateway.findAllTeamRankings();
    }
}
