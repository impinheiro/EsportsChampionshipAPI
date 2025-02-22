package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeamDtoMapper {

    public Team toDomain (TeamDTO teamDTO){
        return new Team(teamDTO.id(), teamDTO.name(), teamDTO.members().stream()
                .map(userDTO -> new User(userDTO.id(), userDTO.name(),
                        userDTO.email(), userDTO.nickname(),
                        userDTO.password(), userDTO.birthday(),
                        userDTO.profilePhoto(), userDTO.role()))
                .collect(Collectors.toList()));
    }
    public TeamDTO toDTO(Team team){
        return new TeamDTO(team.id(), team.name(), team.members().stream()
                .map(user -> new UserDTO(user.id(), user.name(),
                        user.email(), user.nickname(),
                        user.password(), user.birthday(),
                        user.profilePhoto(), user.role()))
                .collect(Collectors.toList()));

    }
}
