package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class TeamDtoMapper {

    private UserDtoMapper userDtoMapper;

    public Team toDomain (TeamDTO teamDTO){
        if(teamDTO.membersId() == null) {
            return new Team(teamDTO.id(), teamDTO.name(), new ArrayList<>());
        }else{
            return new Team(teamDTO.id(), teamDTO.name(), teamDTO.membersId());
        }

    }
    public TeamDTO toDTO(Team team){
        if(team.membersId() == null) {
            return new TeamDTO(team.id(), team.name(), new ArrayList<>());
        }else {
            return new TeamDTO(team.id(), team.name(),team.membersId());
        }

    }
}
