package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class DeleteTeamRankingCaseImpl implements DeleteTeamRankingCase {

    private final RankingGateway rankingGateway;

    public DeleteTeamRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public void execute(String id) {
        rankingGateway.deleteTeamRanking(id);
    }
}
