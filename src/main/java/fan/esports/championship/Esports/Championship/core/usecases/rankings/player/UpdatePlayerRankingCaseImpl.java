package fan.esports.championship.Esports.Championship.core.usecases.rankings.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class UpdatePlayerRankingCaseImpl implements UpdatePlayerRankingCase {

    private final RankingGateway rankingGateway;

    public UpdatePlayerRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public PlayerRanking execute(String id, PlayerRanking playerRanking) {
        return rankingGateway.updatePlayerRanking(id, playerRanking);
    }
}
