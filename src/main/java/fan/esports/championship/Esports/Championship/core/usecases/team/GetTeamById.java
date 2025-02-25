package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;

public interface GetTeamById {
    Team execute(String id);
}
