package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;

import java.util.List;

public interface GetAllTeamsCase {
    public List<Team> findAllTeams();
}
