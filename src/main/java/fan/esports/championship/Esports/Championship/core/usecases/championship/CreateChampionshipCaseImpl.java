package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.MissingPermissionException;

public class CreateChampionshipCaseImpl implements CreateChampionshipCase {
    private final ChampionshipGateway championshipGateway;
    private final UserGateway userGateway;

    public CreateChampionshipCaseImpl(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        this.championshipGateway = championshipGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Championship execute(Championship championship) {
        if(userGateway.getAuthenticatedUser().role().name().equals("PLAYER")){
            throw new MissingPermissionException("You are not an ADMIN or PROMOTER");
        }
        return championshipGateway.create(championship);
    }
}
