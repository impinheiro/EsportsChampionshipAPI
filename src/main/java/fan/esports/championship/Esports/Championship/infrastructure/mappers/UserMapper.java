package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDto;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.UserEntity;

public class UserMapper {

    public static UserDto toDto(UserEntity user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getNickname(),
                user.getPassword(), user.getBirthday(), user.getProfilePhoto(), user.getRole());
    }
    public static UserEntity toEntity(UserDto userDto) {
        return new UserEntity(
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
