package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class CreateTeamRankingCaseImpl implements CreateTeamRankingCase {
    private final RankingGateway rankingGateway;

    public CreateTeamRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public TeamRanking execute(TeamRanking teamRanking) {
        return rankingGateway.createTeamRanking(teamRanking);
    }
}
