package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;

public interface UpdateChampionshipCase {
     Championship execute (String id, Championship championship);
}
