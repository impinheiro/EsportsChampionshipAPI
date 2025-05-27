package fan.esports.championship.Esports.Championship.infrastructure.mappers.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.stereotype.Component;


@Component
public class TeamEntityMapper {

    public Team toDomain (TeamEntity teamEntity){
        return new Team(teamEntity.getId(),
                teamEntity.getName(),
                teamEntity.getMembersId(),
                teamEntity.getCreatedAt(),
                teamEntity.getUpdatedAt());
    }

    public TeamEntity toEntity(Team team){
        return new TeamEntity(team.id(),
                team.name(),
                team.membersId(),
                team.createdAt(),
                team.updatedAt());
    }


}
