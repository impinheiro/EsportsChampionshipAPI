package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.InvalidLoginParameterException;

public class LoginUserCaseImpl implements LoginUserCase {
    private final UserGateway userGateway;

    public LoginUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public String execute(String email, String password) {
        if(userGateway.isValid(email, password)) {
            return userGateway.login(email, password);
        }
        throw new InvalidLoginParameterException("Invalid email or password");
    }
}
