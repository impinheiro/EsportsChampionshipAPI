package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

public class FindChampionshipByIdCaseImpl implements FindChampionshipByIdCase {
    private final ChampionshipGateway championshipGateway;

    public FindChampionshipByIdCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public Championship execute(String id) {
        return championshipGateway.findById(id).orElse(null);
    }
}
