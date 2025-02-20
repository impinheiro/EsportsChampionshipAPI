package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;

import java.util.List;

public interface GetUsersCase {
    public List<User> getUsers();
}
