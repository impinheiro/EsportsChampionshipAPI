package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;

public interface CreateRankingCase {

    Ranking execute(Ranking playerRanking);
}
