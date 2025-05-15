package fan.esports.championship.Esports.Championship.core.usecases.rankings.player;

import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class DeletePlayerRankingCaseImpl implements DeletePlayerRankingCase {

    private final RankingGateway rankingGateway;

    public DeletePlayerRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public void execute(String id) {
        rankingGateway.deletePlayerRanking(id);
    }
}
