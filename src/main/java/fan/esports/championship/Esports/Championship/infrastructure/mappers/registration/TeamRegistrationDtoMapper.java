package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamRegistrationDTO;
import org.springframework.stereotype.Component;

@Component
public class TeamRegistrationDtoMapper {
    private final TeamDtoMapper teamDtoMapper;

    public TeamRegistrationDtoMapper(TeamDtoMapper teamDtoMapper) {
        this.teamDtoMapper = teamDtoMapper;
    }
    public TeamRegistrationDTO toDTO(TeamRegistration teamRegistration) {
        return new  TeamRegistrationDTO(teamRegistration.id(), teamDtoMapper.toDTO(teamRegistration.team()));
    }
    public TeamRegistration toDomain(TeamRegistrationDTO teamRegistrationDTO) {
        return new TeamRegistration(teamRegistrationDTO.id(), teamDtoMapper.toDomain(teamRegistrationDTO.teamDTO()));
    }
}
