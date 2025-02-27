package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class DeleteUserCaseImpl implements DeleteUserCase {
    private UserGateway userGateway;

    public DeleteUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(String id) {
        userGateway.delete(id);
    }
}
