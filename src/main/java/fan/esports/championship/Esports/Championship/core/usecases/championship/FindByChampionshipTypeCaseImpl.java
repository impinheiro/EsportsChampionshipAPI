package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

import java.util.List;

public class FindByChampionshipTypeCaseImpl implements FindByChampionshipTypeCase {
    private final ChampionshipGateway championshipGateway;

    public FindByChampionshipTypeCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public List<Championship> execute(String championshipType) {
        return championshipGateway.findByChampionshipType(championshipType);
    }
}
