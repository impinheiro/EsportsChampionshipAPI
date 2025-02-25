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
        return new Team(teamDTO.id(), teamDTO.name(), teamDTO.members()==null ? new ArrayList<>() : teamDTO.members()
                .stream()
                .map(userDtoMapper::toDomain)
                .collect(Collectors.toList()));
    }
    public TeamDTO toDTO(Team team){
        return new TeamDTO(team.id(), team.name(), team.members() == null ? new ArrayList<>() : team.members()
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList()));
    }
}
