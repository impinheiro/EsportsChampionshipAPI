package fan.esports.championship.Esports.Championship.infrastructure.mappers.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeamDtoMapper {

    private UserDtoMapper userMapper;

    public TeamDtoMapper(UserDtoMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Team toDomain (TeamDTO teamDTO){
        return new Team(teamDTO.id(),
                teamDTO.name(),
                teamDTO.members()
                        .stream()
                        .map(userMapper::toDomain)
                        .collect(Collectors.toList()),
                teamDTO.createdAt(),
                teamDTO.updatedAt());
    }
    public TeamDTO toDTO(Team team){
        return new TeamDTO(team.id(),
                team.name(),
                team.members()
                        .stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList()),
                team.createdAt(),
                team.updatedAt());
    }
}
