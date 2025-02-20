package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO toDto(UserEntity user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getNickname(),
                user.getPassword(), user.getBirthday(), user.getProfilePhoto(), user.getRole());
    }
    public static UserEntity toEntity(UserDTO userDto) {
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
