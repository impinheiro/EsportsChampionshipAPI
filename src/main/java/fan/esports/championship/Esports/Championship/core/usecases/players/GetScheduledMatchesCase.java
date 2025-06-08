package fan.esports.championship.Esports.Championship.core.usecases.players;

import fan.esports.championship.Esports.Championship.core.domain.Match;

import java.util.List;

public interface GetScheduledMatchesCase {
    List<Match> execute();
}
