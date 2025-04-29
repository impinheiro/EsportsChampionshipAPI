package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;

import java.util.List;

public interface FindByChampionshipFormatCase {
    List<Championship> execute(String championshipFormat);
}
