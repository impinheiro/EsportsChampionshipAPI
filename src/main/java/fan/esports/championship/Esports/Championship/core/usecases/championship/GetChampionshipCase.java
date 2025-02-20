package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;

import java.util.List;

public interface GetChampionshipCase {
    public List<Championship> execute();
}
