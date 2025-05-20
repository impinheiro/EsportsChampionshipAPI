package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;

import java.util.List;
import java.util.Optional;

public interface MatchGateway {
    Match create(Match match);
    Match update(String id, Match match);
    void delete(String id);
    Optional<Match> findById(String id);
    List<Match> findAll();
    void setChampionshipId(String matchId, String championshipId);

}
