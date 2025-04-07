package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;

public interface FindTeamMatchById {
    TeamMatch execute(String id);
}
