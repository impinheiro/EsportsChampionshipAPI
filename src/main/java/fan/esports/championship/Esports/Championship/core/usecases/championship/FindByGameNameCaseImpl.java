package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

import java.util.List;

public class FindByGameNameCaseImpl implements FindByGameNameCase {
    private final ChampionshipGateway championshipGateway;

    public FindByGameNameCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public List<Championship> execute(String gameName) {
        return championshipGateway.findByGameName(gameName);
    }
}
