package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.UserNotFoundException;

public class CreateTeamCaseImpl implements CreateTeamCase {

    private final TeamGateway teamGateway;
    private final UserGateway userGateway;

    public CreateTeamCaseImpl(TeamGateway teamGateway, UserGateway userGateway) {
        this.teamGateway = teamGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Team execute(Team team) {
        for(String userId : team.membersId()){
            if(!userGateway.exists(userId)){
                throw new UserNotFoundException("User not found on database. Please register first");
            }
        }
         return teamGateway.createTeam(team);
    }
}
