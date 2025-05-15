package fan.esports.championship.Esports.Championship.core.usecases.rankings.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

public class CreatePlayerRankingCaseImpl implements CreatePlayerRankingCase {

    private final RankingGateway rankingGateway;

    public CreatePlayerRankingCaseImpl(RankingGateway rankingGateway) {
        this.rankingGateway = rankingGateway;
    }

    @Override
    public PlayerRanking execute(PlayerRanking playerRanking) {
        return rankingGateway.createPlayerRanking(playerRanking);
    }
}
