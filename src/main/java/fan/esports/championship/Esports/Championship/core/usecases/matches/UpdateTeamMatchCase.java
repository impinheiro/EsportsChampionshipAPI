package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;

public interface UpdateTeamMatchCase {
    TeamMatch execute(String id,TeamMatch teamMatch);
}
