package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;

import java.util.List;

public interface FindAllRankingsCase {
    List<Ranking> execute();
}
