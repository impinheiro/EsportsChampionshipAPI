package fan.esports.championship.Esports.Championship.core.usecases.rankings.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;

import java.util.List;

public interface FindPlayerRankingsCase {
    List<PlayerRanking> execute();
}
