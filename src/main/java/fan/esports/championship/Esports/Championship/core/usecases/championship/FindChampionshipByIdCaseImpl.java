package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.MissingPermissionException;

public class FindChampionshipByIdCaseImpl implements FindChampionshipByIdCase {
    private final ChampionshipGateway championshipGateway;
    private final UserGateway userGateway;

    public FindChampionshipByIdCaseImpl(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        this.championshipGateway = championshipGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Championship execute(String id) {
        if(userGateway.getAuthenticatedUser().role().name().equals("PLAYER")){
            throw new MissingPermissionException("You are not an ADMIN or PROMOTER");
        }
        return championshipGateway.findById(id).orElse(null);
    }
}
