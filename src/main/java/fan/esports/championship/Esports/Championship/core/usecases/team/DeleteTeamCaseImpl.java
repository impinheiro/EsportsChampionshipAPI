package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;

public class DeleteTeamCaseImpl implements  DeleteTeamCase {
    private TeamGateway teamGateway;

    public DeleteTeamCaseImpl(TeamGateway teamGateway) {
        this.teamGateway = teamGateway;
    }

    @Override
    public void execute(String id) {
        teamGateway.deleteTeam(id);
    }
}
