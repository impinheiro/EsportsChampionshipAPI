package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;

import java.util.List;
import java.util.Optional;

public interface RankingGateway {

    Ranking createRanking(Ranking playerRanking);
    Optional<Ranking> findById(String id);
    List<Ranking> findAll();
    Ranking update(String id, Ranking playerRanking);
    void delete(String id);
}
