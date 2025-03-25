package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.UserRequestDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserDTO toDto(User user) {
        return new UserDTO(user.id(),
                user.name(),
                user.email(),
                user.nickname(),
                user.password(),
                user.birthday(),
                user.profilePhoto(),
                user.role(),
                user.createdAt(),
                user.updatedAt());
    }
    public User toDomain(UserDTO userDto) {
        return new User(
                userDto.id(),
                userDto.name(),
                userDto.email(),
                userDto.nickname(),
                userDto.password(),
                userDto.birthday(),
                userDto.profilePhoto(),
                userDto.role(),
                userDto.createdAt(),
                userDto.updatedAt()
        );
    }
    public UserResponseDTO toResponseDto(UserDTO user) {
        return new UserResponseDTO(
                user.id(),
                user.nickname(),
                user.email()
        );
    }
}
