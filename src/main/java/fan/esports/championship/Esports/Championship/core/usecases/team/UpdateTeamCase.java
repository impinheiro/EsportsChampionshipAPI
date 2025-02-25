package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;

public interface UpdateTeamCase {
    Team execute(Team team, String id);
}
