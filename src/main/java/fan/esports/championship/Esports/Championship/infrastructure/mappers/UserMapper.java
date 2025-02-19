package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDto;

public class UserMapper {

    public static UserDto toDto(User user) {
        return new UserDto(user.id(), user.nome(), user.email(), user.nickname(),
                user.password(), user.birthday(), user.profilePhoto(), user.role());
    }
    public static User toEntity(UserDto userDto) {
        return new User(
                userDto.id(),
                userDto.nome(),
                userDto.email(),
                userDto.nickname(),
                userDto.password(),
                userDto.birthday(),
                userDto.profilePhoto(),
                userDto.role()
        );
    }
}
