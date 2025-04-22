package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class PromoteUserCaseImpl implements PromoteUserCase {
    private final UserGateway userGateway;

    public PromoteUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(String id, String role) {
        return userGateway.promote(id, role);
    }
}
