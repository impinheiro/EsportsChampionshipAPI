package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class FindUserByIdImpl implements FindUserById {
    private UserGateway userGateway;
    public FindUserByIdImpl(UserGateway userGateway) {}
    @Override
    public User execute(String id) {
        return userGateway.findById(id);
    }
}
