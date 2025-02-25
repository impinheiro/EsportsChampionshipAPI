package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;

public class GetTeamByIdImpl implements GetTeamById {
    private final TeamGateway teamGateway;

    public GetTeamByIdImpl(TeamGateway teamGateway) {
        this.teamGateway = teamGateway;
    }

    @Override
    public Team execute(String id) {
        return teamGateway.findTeamById(id);
    }
}
