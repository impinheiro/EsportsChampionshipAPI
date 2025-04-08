package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

import java.util.List;

public class FindAllChampionshipsCaseImpl implements FindAllChampionshipsCase {
    private final ChampionshipGateway championshipGateway;

    public FindAllChampionshipsCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public List<Championship> execute() {
        return championshipGateway.findAll();
    }
}
