package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.MatchInfo;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.Participant;

import java.util.List;

public record ChampionshipResponse(String id,
                                   String name,
                                   String gameName,
                                   ChampionshipType type,
                                   Integer capacity,
                                   double subscriptionValue,
                                   ChampionshipFormat format,
                                   String rules,
                                   String startDate,
                                   String endDate,
                                   String location,
                                   String coverImage,
                                   String logoImage,
                                   String awardDescription,
                                   String rankingId,
                                   List<Participant> participants,
                                   List<MatchInfo> matches) {
}
