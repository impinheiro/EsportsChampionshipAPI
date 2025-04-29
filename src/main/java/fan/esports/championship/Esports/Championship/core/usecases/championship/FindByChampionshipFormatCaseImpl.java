package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

import java.util.List;

public class FindByChampionshipFormatCaseImpl implements FindByChampionshipFormatCase {
    private final ChampionshipGateway championshipGateway;

    public FindByChampionshipFormatCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public List<Championship> execute(String championshipFormat) {
        return championshipGateway.findByChampionshipFormat(championshipFormat);
    }
}
