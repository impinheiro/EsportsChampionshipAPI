package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class FindUserByIdCaseImpl implements FindUserByIdCase {

    private final UserGateway userGateway;

    public FindUserByIdCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }
    @Override
    public User execute(String id) {
        return userGateway.findById(id);
    }
}
