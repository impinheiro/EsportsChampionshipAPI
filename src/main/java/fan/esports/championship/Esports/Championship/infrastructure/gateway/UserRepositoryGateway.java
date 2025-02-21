package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.UserEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class UserRepositoryGateway implements UserGateway {

    private UserRepository userRepository;
    private UserEntityMapper mapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = mapper.toEntity(user);
        UserEntity newUser = userRepository.save(userEntity);
        return mapper.toDomain(newUser);
    }

    @Override
    public User update(User user, String id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityList.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User delete(String id) {
        return null;
    }
}
