package fan.esports.championship.Esports.Championship.core.usecases.rankings.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;

public interface FindPlayerRankingByIdCase {
    PlayerRanking execute(String id);
}
