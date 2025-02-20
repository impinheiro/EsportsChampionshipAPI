package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;

public interface UpdateUserCase {
    public User execute(User user, String id);
}
