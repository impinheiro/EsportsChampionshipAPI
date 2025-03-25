package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class UpdateUserCaseImpl implements UpdateUserCase {
    private final UserGateway userGateway;

    public UpdateUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user, String id) {
        return userGateway.update(user, id);
    }
}
