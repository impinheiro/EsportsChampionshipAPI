package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;

public class UpdateTeamCaseImpl implements UpdateTeamCase {

    private final TeamGateway teamGateway;
    public UpdateTeamCaseImpl(TeamGateway teamGateway) {
        this.teamGateway = teamGateway;
    }

    @Override
    public Team execute(Team team, String id) {
        teamGateway.updateTeam(team, id);
        return team;
    }
}
