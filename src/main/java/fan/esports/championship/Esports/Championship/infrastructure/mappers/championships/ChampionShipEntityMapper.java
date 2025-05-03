package fan.esports.championship.Esports.Championship.infrastructure.mappers.championships;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import org.springframework.stereotype.Component;

@Component
public class ChampionShipEntityMapper {

    public Championship toDomain(ChampionshipEntity championshipData){
        return new Championship(
                championshipData.getId(),
                championshipData.getCreatedBy(),
                championshipData.getName(),
                championshipData.getGameName(),
                championshipData.getType(),
                championshipData.getCapacity(),
                championshipData.getSubscriptionValue(),
                championshipData.getFormat(),
                championshipData.getRules(),
                championshipData.getStartDate(),
                championshipData.getEndDate(),
                championshipData.getLocation(),
                championshipData.getCoverImage(),
                championshipData.getLogoImage(),
                championshipData.getAwardDescription(),
                championshipData.getRegistrationsId(),
                championshipData.getMatchesId(),
                championshipData.getCreatedAt(),
                championshipData.getUpdatedAt()
        );
    }
    public ChampionshipEntity toEntity(Championship championship){
        return new ChampionshipEntity(
                championship.id(),
                championship.createdBy(),
                championship.name(),
                championship.gameName(),
                championship.type(),
                championship.capacity(),
                championship.subscriptionValue(),
                championship.format(),
                championship.rules(),
                championship.startDate(),
                championship.endDate(),
                championship.location(),
                championship.coverImage(),
                championship.logoImage(),
                championship.awardDescription(),
                championship.registrationsId(),
                championship.matchesId(),
                championship.createdAt(),
                championship.updatedAt()
        );
    }
}
