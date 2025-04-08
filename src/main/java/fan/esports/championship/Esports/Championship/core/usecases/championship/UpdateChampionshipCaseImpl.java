package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

public class UpdateChampionshipCaseImpl implements UpdateChampionshipCase {
    private final ChampionshipGateway championshipGateway;

    public UpdateChampionshipCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public Championship execute(String id, Championship championship) {
        return championshipGateway.update(id, championship);
    }
}

