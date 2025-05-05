package fan.esports.championship.Esports.Championship.core.usecases.promoters;


import fan.esports.championship.Esports.Championship.core.domain.Championship;

import java.util.List;

public interface FindProprietaryChampionshipsCase {
    List<Championship> execute();
}
