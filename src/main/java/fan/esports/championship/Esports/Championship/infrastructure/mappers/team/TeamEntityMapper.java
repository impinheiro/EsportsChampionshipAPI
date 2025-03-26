package fan.esports.championship.Esports.Championship.infrastructure.mappers.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class TeamEntityMapper {

    private UserEntityMapper userMapper;

    public TeamEntityMapper(UserEntityMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Team toDomain (TeamEntity teamEntity){
        return new Team(teamEntity.getId(),
                teamEntity.getName(),
                teamEntity.getMembers()
                        .stream()
                        .map(userMapper::toDomain)
                        .collect(Collectors.toList()),
                teamEntity.getCreatedAt(),
                teamEntity.getUpdatedAt());
    }

    public TeamEntity toEntity(Team team){
        return new TeamEntity(team.id(),
                team.name(),
                team.members()
                        .stream()
                        .map(userMapper::toEntity)
                        .collect(Collectors.toList()),
                team.createdAt(),
                team.updatedAt());
    }


}
