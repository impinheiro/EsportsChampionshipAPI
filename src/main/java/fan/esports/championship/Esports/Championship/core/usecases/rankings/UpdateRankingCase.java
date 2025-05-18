package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;

public interface UpdateRankingCase {
    Ranking execute(String id, Ranking playerRanking);
}
