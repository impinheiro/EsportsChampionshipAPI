package fan.esports.championship.Esports.Championship.infrastructure.mappers.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import org.springframework.stereotype.Component;

@Component
public class TeamDtoMapper {

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

}
