package fan.esports.championship.Esports.Championship.infrastructure.mappers.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamMember;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.TeamResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamDtoMapper {

    private final UserGateway userGateway;

    public TeamDtoMapper(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Team toDomain (TeamDTO teamDTO){

        return new Team(teamDTO.id(),
                teamDTO.name(),
                teamDTO.membersId(),
                teamDTO.createdAt(),
                teamDTO.updatedAt()
        );
    }
    public TeamDTO toDTO(Team team){

        return new TeamDTO(team.id(),
                team.name(),
                team.membersId(),
                team.createdAt(),
                team.updatedAt()
        );

    }

    public TeamResponse toResponse(Team team){
        List<TeamMember> members = new ArrayList<>();
        for(String id : team.membersId()){
           User user = userGateway.findById(id).orElse(null);
           TeamMember member = new TeamMember(user.id(),  user.email(), user.nickname());
           members.add(member);
        }
        return new TeamResponse(
                team.id(),
                team.name(),
                members
        );
    }

}
