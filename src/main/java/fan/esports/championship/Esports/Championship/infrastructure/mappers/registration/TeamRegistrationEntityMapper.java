package fan.esports.championship.Esports.Championship.infrastructure.mappers.registration;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.TeamRegistrationEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamRegistrationEntityMapper {
    private final TeamEntityMapper teamEntityMapper;

    public TeamRegistrationEntityMapper(TeamEntityMapper teamEntityMapper) {
        this.teamEntityMapper = teamEntityMapper;
    }

    public TeamRegistration toDomain(TeamRegistrationEntity teamRegistrationEntity){
        return new TeamRegistration(
                teamRegistrationEntity.getId(),
                teamEntityMapper.toDomain(teamRegistrationEntity.getTeam()),
                teamRegistrationEntity.getStatus()
        );
    }

    public TeamRegistrationEntity toEntity(TeamRegistration teamRegistration){
        return new TeamRegistrationEntity(
                teamRegistration.id(),
                teamEntityMapper.toEntity(teamRegistration.team()),
                teamRegistration.status()
        );
    }
}
