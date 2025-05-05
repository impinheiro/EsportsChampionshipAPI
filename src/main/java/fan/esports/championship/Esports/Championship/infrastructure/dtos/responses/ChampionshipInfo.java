package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;

public record ChampionshipInfo(String championshipName,
                               String gameName,
                               ChampionshipType championshipType,
                               ChampionshipFormat championshipFormat,
                               String rules,
                               String awards,
                               Integer vacancies,
                               Integer availableVacancies) {
}
