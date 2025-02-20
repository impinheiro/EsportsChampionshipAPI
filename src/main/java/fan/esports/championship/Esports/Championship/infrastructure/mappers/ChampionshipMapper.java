package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.ChampionshipEntity;
import org.springframework.stereotype.Component;

@Component
public class ChampionshipMapper {
    public static ChampionshipDTO toDto(ChampionshipEntity championship){
        return new ChampionshipDTO(championship.getId(), championship.getName(), championship.getGameName(),
                championship.getType(), championship.getCapacity(),
                championship.getSubscriptionValue(), championship.getFormat(),
                championship.getRules(), championship.getStartDate(),
                championship.getEndDate(), championship.getLocation(),
                championship.getCoverImage(), championship.getLogoImage(),
                championship.getAwardDescription());
    }
    public static ChampionshipEntity toEntity(ChampionshipDTO dto){
        return new ChampionshipEntity(dto.id(), dto.name(), dto.gameName(), dto.championshipType(),
                dto.capacity(), dto.subscriptionValue(), dto.championshipFormat(), dto.rules(),
                dto.startDate(), dto.endDate(), dto.location(), dto.coverImage(), dto.logoImage(),
                dto.awardDescription());
    }
}
