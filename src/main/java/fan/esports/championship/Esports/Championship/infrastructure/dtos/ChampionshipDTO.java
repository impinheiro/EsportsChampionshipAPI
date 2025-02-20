package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ChampionshipDTO(String id, String name, String gameName,
                              ChampionshipType championshipType, Integer capacity,
                              double subscriptionValue, ChampionshipFormat championshipFormat,
                              String rules, LocalDateTime startDate, LocalDateTime endDate,
                              String location, String coverImage, String logoImage,
                              String awardDescription)  {

}
