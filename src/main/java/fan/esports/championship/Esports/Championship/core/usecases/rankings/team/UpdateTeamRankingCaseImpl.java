package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class UpdateTeamRankingCaseImpl implements UpdateTeamRankingCase {

    private final RankingGateway rankingGateway;

    public UpdateTeamRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public TeamRanking execute(String id, TeamRanking teamRanking) {
        return rankingGateway.updateTeamRanking(id, teamRanking);
    }
}
