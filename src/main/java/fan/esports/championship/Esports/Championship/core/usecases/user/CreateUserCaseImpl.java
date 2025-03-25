package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.UserAlreadyExistsException;

public class CreateUserCaseImpl implements CreateUserCase {

    private final UserGateway userGateway;

    public CreateUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        if(userGateway.existsByEmail(user.email()))
            throw new UserAlreadyExistsException("This email is already registered");
        else if(userGateway.existsByNickname(user.nickname()))
            throw new UserAlreadyExistsException("This nickname is already on use");
        return userGateway.create(user);
    }
}
