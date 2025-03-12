package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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
    public void delete(String id) {
        UserEntity userToDelete = userRepository.findById(id).orElse(null);
        userRepository.delete(userToDelete);
    }

    @Override
        public Optional<User> findById(String id) {
        UserEntity userFound = userRepository.findById(id).orElse(null);
        if(userFound != null){
            return Optional.of(mapper.toDomain(userFound));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        UserEntity userFound = userRepository.findByNickname(nickname).orElse(null);
        if(userFound != null){
            return Optional.of(mapper.toDomain(userFound));
        }
        return Optional.empty();
    }

    @Override
    public boolean exists(String id) {
        return userRepository.findAll().stream().anyMatch(user -> user.getId().equals(id));
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return userRepository.findAll().stream().anyMatch(user -> user.getNickname().equals(nickname));
    }
}
