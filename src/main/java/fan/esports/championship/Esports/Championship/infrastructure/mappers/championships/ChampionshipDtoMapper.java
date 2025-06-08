package fan.esports.championship.Esports.Championship.infrastructure.mappers.championships;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.ChampionshipCreationDto;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.ChampionshipInfo;
import fan.esports.championship.Esports.Championship.infrastructure.gateway.RegistrationRepositoryGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChampionshipDtoMapper {

    private final RegistrationGateway registrationGateway;

    public ChampionshipDtoMapper(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    public Championship toDomain(ChampionshipDTO dto) {
        return new Championship(
                dto.id(),
                dto.createdBy(),
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
                dto.rankingId(),
                dto.registrationsId(),
                dto.matchesId(),
                dto.createdAt(),
                dto.updatedAt()
        );
    }

    public ChampionshipDTO toDto(Championship championship) {
        List<String> acceptedRegistrations = new ArrayList<>();
        for(String registrationId : championship.registrationsId()){
            Registration registration = registrationGateway.findById(registrationId).orElse(null);
            if(registration.status().equals(RegistrationStatus.ACCEPTED)){
                acceptedRegistrations.add(registrationId);
            }
        }
        return new ChampionshipDTO(
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
                acceptedRegistrations,
                championship.matchesId(),
                championship.createdAt(),
                championship.updatedAt()
        );
    }

    public Championship toDomain(ChampionshipCreationDto championship) {
        return new Championship(
                null,
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
                null,
                null
        );
    }

    public ChampionshipInfo toInfo(Championship dto) {
        Integer availableVacancies = calculateVacancies(dto);
        return new ChampionshipInfo(
                dto.name(),
                dto.gameName(),
                dto.type(),
                dto.format(),
                dto.rules(),
                dto.awardDescription(),
                dto.capacity(),
                availableVacancies
                );
    }

    public static Integer calculateVacancies(Championship championshipDTO) {
        Integer vacancies = championshipDTO.capacity();
        Integer registrations = championshipDTO.registrationsId().size();
        return vacancies - registrations;
    }
}
