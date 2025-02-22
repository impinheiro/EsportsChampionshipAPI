package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;

public class CreateTeamCaseImpl implements CreateTeamCase {

    private final TeamGateway teamGateway;

    public CreateTeamCaseImpl(TeamGateway teamGateway) {
        this.teamGateway = teamGateway;
    }

    @Override
    public Team execute(Team team) {
        Team newTeam = teamGateway.createTeam(team);
        return newTeam;
    }
}
