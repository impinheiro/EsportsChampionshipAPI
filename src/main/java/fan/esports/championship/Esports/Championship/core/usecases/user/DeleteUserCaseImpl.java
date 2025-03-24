package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.MissingPermissionException;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.UserNotFoundException;

public class DeleteUserCaseImpl implements DeleteUserCase {
    private final UserGateway userGateway;
    private final AuthenticatedUserCase authenticatedUserCase;

    public DeleteUserCaseImpl(UserGateway userGateway, AuthenticatedUserCase authenticatedUserCase) {
        this.userGateway = userGateway;

        this.authenticatedUserCase = authenticatedUserCase;
    }

    @Override
    public void execute(String id) {
        if(!userGateway.exists(id)){
            throw new UserNotFoundException("User not found");
        }
        if(!userGateway.getAuthenticatedUser().role().name().equals("ADMIN")){
            throw new MissingPermissionException("User is not an admin");
        }
        userGateway.delete(id);
    }
}
