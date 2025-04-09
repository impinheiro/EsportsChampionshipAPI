package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.MissingPermissionException;

public class DeleteChampionshipCaseImpl implements DeleteChampionshipCase {
    private final ChampionshipGateway championshipGateway;
    private final UserGateway userGateway;

    public DeleteChampionshipCaseImpl(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        this.championshipGateway = championshipGateway;
        this.userGateway = userGateway;
    }

    @Override
    public void execute(String id) {
        if(userGateway.getAuthenticatedUser().role().name().equals("PLAYER")){
            throw new MissingPermissionException("You are not an ADMIN or PROMOTER");
        }
        championshipGateway.delete(id);
    }
}
