package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;

public interface CreateTeamMatchCase {
    TeamMatch execute(TeamMatch teamMatch);
}
