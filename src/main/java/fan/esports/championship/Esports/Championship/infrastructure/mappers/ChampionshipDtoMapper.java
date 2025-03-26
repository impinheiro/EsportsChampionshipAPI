package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ChampionshipDtoMapper {

    private final RegistrationDtoMapper registrationMapper;

    public ChampionshipDtoMapper(RegistrationDtoMapper registrationMapper) {
        this.registrationMapper = registrationMapper;
    }

    public Championship toDomain(ChampionshipDTO championshipDTO){
        return new Championship(championshipDTO.id(), championshipDTO.name(), championshipDTO.gameName(),
                championshipDTO.type(), championshipDTO.capacity(), championshipDTO.subscriptionValue(),
                championshipDTO.format(), championshipDTO.rules(), championshipDTO.startDate(), championshipDTO.endDate(),
                championshipDTO.location(), championshipDTO.coverImage(), championshipDTO.logoImage(),
                championshipDTO.awardDescription(), championshipDTO.registrations()
                .stream()
                .map(registrationMapper::toDomain).collect(Collectors.toList()), championshipDTO.createdAt(), championshipDTO.updatedAt());
    }
}
