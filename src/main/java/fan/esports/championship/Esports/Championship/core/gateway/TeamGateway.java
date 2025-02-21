package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Team;

import java.util.List;

public interface TeamGateway {
    Team findTeamById(String id);
    public List<Team> findAllTeams();
    Team createTeam(Team team);
    Team updateTeam(Team team, String id);
    void deleteTeam(String id);
}
