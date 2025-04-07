package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;

public interface FindMatchByIdCase {
    Match execute(String id);
}
