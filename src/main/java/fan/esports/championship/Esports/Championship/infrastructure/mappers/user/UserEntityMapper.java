package fan.esports.championship.Esports.Championship.infrastructure.mappers.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    public UserEntity toEntity(User user){
        return new UserEntity(user.id(),
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
    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getNickname(),
                userEntity.getPassword(),
                userEntity.getBirthday(),
                userEntity.getProfilePhoto(),
                userEntity.getRole(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt());
    }
}
