package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class DeleteRankingCaseImpl implements DeleteRankingCase {

    private final RankingGateway rankingGateway;

    public DeleteRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public void execute(String id) {
        rankingGateway.delete(id);
    }
}
