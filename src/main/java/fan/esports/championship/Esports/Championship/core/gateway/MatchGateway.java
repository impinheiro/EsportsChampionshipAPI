package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Match;

import java.util.List;

public interface MatchGateway {
    Match create(Match match);
    Match update(String id, Match match);
    void delete(String id);
    Match findById(String id);
    List<Match> findAll();
}
