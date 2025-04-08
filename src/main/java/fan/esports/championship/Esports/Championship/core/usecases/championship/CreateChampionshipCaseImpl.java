package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

public class CreateChampionshipCaseImpl implements CreateChampionshipCase {
    private final ChampionshipGateway championshipGateway;

    public CreateChampionshipCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public Championship execute(Championship championship) {
        return championshipGateway.create(championship);
    }
}
