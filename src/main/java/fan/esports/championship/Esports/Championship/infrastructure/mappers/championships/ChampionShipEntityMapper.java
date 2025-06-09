package fan.esports.championship.Esports.Championship.infrastructure.mappers.championships;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChampionShipEntityMapper {

    private final RegistrationGateway registrationGateway;

    public ChampionShipEntityMapper(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

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
                championshipData.getRankingId(),
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
                championship.rankingId(),
                championship.registrationsId(),
                championship.matchesId(),
                championship.createdAt(),
                championship.updatedAt()
        );
    }
    public ChampionshipEntity toAvailable(ChampionshipEntity championshipData){
        List<String> acceptedRegistrations = new ArrayList<>();
        for(String registrationId : championshipData.getRegistrationsId()){
            Registration registration = registrationGateway.findById(registrationId).orElse(null);
            if(registration.status().equals(RegistrationStatus.ACCEPTED)){
                acceptedRegistrations.add(registrationId);
            }
        }
        return new ChampionshipEntity(
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
                championshipData.getRankingId(),
                acceptedRegistrations,
                championshipData.getMatchesId(),
                championshipData.getCreatedAt(),
                championshipData.getUpdatedAt()
        );
    }
}
