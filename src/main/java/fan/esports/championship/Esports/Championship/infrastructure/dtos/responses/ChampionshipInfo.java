package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import fan.esports.championship.Esports.Championship.core.enums.Games;

public record ChampionshipInfo(String championshipName,
                               Games gameName,
                               ChampionshipType championshipType,
                               ChampionshipFormat championshipFormat,
                               String rules,
                               String awards,
                               Integer vacancies,
                               Integer availableVacancies) {
}
