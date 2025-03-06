package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.User;

import java.util.List;

public interface UserGateway {
    User create(User user);
    User update(User user, String id);
    List<User> findAllUsers();
    void delete(String id);
    User findById(String id);
    boolean exists(String id);
}
