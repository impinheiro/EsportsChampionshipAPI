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
        if(teamEntity.getMembersNickname() == null) {
            return new Team(teamEntity.getId(), teamEntity.getName(), new ArrayList<>());
        }else{
            return new Team(teamEntity.getId(), teamEntity.getName(), teamEntity.getMembersNickname());

        }
    }

    public TeamEntity toEntity(Team team){
        if(team.membersId() == null) {
            return new TeamEntity(team.id(), team.name(), new ArrayList<>());
        }else {
            return new TeamEntity(team.id(), team.name(), team.membersId());
        }
    }

}
