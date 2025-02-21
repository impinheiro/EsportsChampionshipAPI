package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;

import java.util.List;

public class GetAllTeamsImpl implements GetAllTeamsCase {

    private final TeamGateway teamGateway;

    public GetAllTeamsImpl(TeamGateway teamGateway) {
        this.teamGateway = teamGateway;
    }

    @Override
    public List<Team> findAllTeams() {
        return teamGateway.findAllTeams();
    }
}
