package fan.esports.championship.Esports.Championship.infrastructure.dtos.requests;

import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import fan.esports.championship.Esports.Championship.core.enums.Games;

import java.time.LocalDateTime;

public record ChampionshipCreationDto(String name,
                                      Games gameName,
                                      ChampionshipType type,
                                      Integer capacity,
                                      double subscriptionValue,
                                      ChampionshipFormat format,
                                      String rules,
                                      LocalDateTime startDate,
                                      LocalDateTime endDate,
                                      String location,
                                      String coverImage,
                                      String logoImage,
                                      String awardDescription) {

}
