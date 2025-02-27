package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;

public interface FindUserById {
    User execute(String id);
}
