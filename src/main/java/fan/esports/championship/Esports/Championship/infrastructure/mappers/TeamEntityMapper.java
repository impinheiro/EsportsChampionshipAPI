package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamEntityMapper {

    private UserEntityMapper userEntityMapper;

    public Team toDomain (TeamEntity teamEntity){
        return new Team(teamEntity.getId(), teamEntity.getName(), teamEntity.getMembers() == null ? new ArrayList<>() : teamEntity.getMembers()
                .stream()
                .map(userEntityMapper::toDomain)
                .collect(Collectors.toList()));
    }

    public TeamEntity toEntity(Team team){
        return new TeamEntity(team.id(), team.name(), team.members() == null ? new ArrayList<>() : team.members()
                .stream()
                .map(userEntityMapper::toEntity)
                .collect(Collectors.toList()));
    }

}
