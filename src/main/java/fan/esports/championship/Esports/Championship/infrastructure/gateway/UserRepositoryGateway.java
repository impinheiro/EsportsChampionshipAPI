package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryGateway implements UserGateway {

    private UserRepository userRepository;

    public UserRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user, String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User delete(String id) {
        return null;
    }
}
