package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;

public interface updateChampionshipCase {
    public Championship execute(Championship championship, String id);
}
