package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamEntityMapper {

    public Team toDomain (TeamEntity teamEntity){
        return new Team(teamEntity.getId(), teamEntity.getName(), teamEntity.getMembers().stream()
                .map(userEntity -> new User(userEntity.getId(), userEntity.getName(),
                        userEntity.getEmail(), userEntity.getNickname(),
                        userEntity.getPassword(), userEntity.getBirthday(),
                        userEntity.getProfilePhoto(), userEntity.getRole()))
                .collect(Collectors.toList()));
    }

    public TeamEntity toEntity(Team team){
        return new TeamEntity(team.id(), team.name(), team.members().stream()
                .map(user -> new UserEntity(user.id(), user.name(),
                        user.email(), user.nickname(),
                        user.password(), user.birthday(),
                        user.profilePhoto(), user.role()))
                .collect(Collectors.toList()));
    }

}
