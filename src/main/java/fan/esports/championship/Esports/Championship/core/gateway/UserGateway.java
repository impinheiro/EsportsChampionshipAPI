package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.domain.UserInfo;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    User create(User user);
    User update(User user, String id);
    List<User> findAllUsers();
    void delete(String id);
    Optional<User> findById(String id);
    Optional<User> findByNickname(String nickname);
    UserInfo getAuthenticatedUser();
    String login(String email, String password);
    boolean isValid(String email,String password);
    boolean exists(String id);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
}
