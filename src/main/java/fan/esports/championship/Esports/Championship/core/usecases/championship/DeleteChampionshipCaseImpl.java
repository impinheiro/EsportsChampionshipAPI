package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

public class DeleteChampionshipCaseImpl implements DeleteChampionshipCase {
    private final ChampionshipGateway championshipGateway;

    public DeleteChampionshipCaseImpl(ChampionshipGateway championshipGateway) {
        this.championshipGateway = championshipGateway;
    }

    @Override
    public void execute(String id) {
        championshipGateway.delete(id);
    }
}
