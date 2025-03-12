package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.UserNotFoundException;

public class FindUserByIdCaseImpl implements FindUserByIdCase {

    private final UserGateway userGateway;

    public FindUserByIdCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }
    @Override
    public User execute(String id) {
        if(!userGateway.exists(id)){
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        return userGateway.findById(id).orElse(null);
    }
}
