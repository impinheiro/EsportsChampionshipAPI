package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;

public interface UpdateMatchCase {
    Match execute(String id, Match match);
}
