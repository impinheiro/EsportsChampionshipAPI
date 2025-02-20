package fan.esports.championship.Esports.Championship.core.usecases;

import fan.esports.championship.Esports.Championship.core.domain.User;

public interface updateUserCase {
    public User execute(User user, String id);
}
