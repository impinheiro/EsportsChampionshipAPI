package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class LoginUserCaseImpl implements LoginUserCase {
    private final UserGateway userGateway;

    public LoginUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public String execute(String email, String password) {
        return userGateway.login(email, password);
    }
}
