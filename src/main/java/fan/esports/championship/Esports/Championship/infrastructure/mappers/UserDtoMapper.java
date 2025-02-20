package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public static UserDTO toDto(User user) {
        return new UserDTO(user.id(),
                user.name(),
                user.email(),
                user.nickname(),
                user.password(),
                user.birthday(),
                user.profilePhoto(),
                user.role());
    }
    public static User toDomain(UserDTO userDto) {
        return new User(
                userDto.id(),
                userDto.name(),
                userDto.email(),
                userDto.nickname(),
                userDto.password(),
                userDto.birthday(),
                userDto.profilePhoto(),
                userDto.role()
        );
    }
}
