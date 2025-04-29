package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;

import java.util.List;

public interface FindExpiredChampionshipsCase {
    List<Championship> execute();
}
