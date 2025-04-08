package fan.esports.championship.Esports.Championship.infrastructure.mappers.championships;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.ChampionshipCreationDto;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ChampionshipDtoMapper {

    public Championship toDomain(ChampionshipDTO dto) {
        return new Championship(
                dto.id(),
                dto.name(),
                dto.gameName(),
                dto.type(),
                dto.capacity(),
                dto.subscriptionValue(),
                dto.format(),
                dto.rules(),
                dto.startDate(),
                dto.endDate(),
                dto.location(),
                dto.coverImage(),
                dto.logoImage(),
                dto.awardDescription(),
                dto.registrationsId(),
                dto.matchesId(),
                dto.createdAt(),
                dto.updatedAt()
        );
    }

    public ChampionshipDTO toDto(Championship championship) {
        return new ChampionshipDTO(
                championship.id(),
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

    public Championship toDomain(ChampionshipCreationDto championship) {
        return new Championship(
                null,
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
                null,
                null,
                null,
                null
        );
    }
}
