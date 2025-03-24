package fan.esports.championship.Esports.Championship.core.usecases.user;


import fan.esports.championship.Esports.Championship.core.domain.UserInfo;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class AuthenticatedUserCaseImpl implements AuthenticatedUserCase {
    private final UserGateway userGateway;

    public AuthenticatedUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserInfo getAuthenticatedUser() {
        return userGateway.getAuthenticatedUser();
    }
}
