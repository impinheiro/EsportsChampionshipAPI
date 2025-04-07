package fan.esports.championship.Esports.Championship.infrastructure.mappers.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.TeamMatchEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeamMatchEntityMapper {

    private final TeamEntityMapper teamMapper;

    public TeamMatchEntityMapper(TeamEntityMapper teamMapper) {
        this.teamMapper = teamMapper;
    }


    public  TeamMatch toDomain(TeamMatchEntity teamMatchEntity){
        return new TeamMatch(
                teamMatchEntity.getId(), teamMatchEntity.getName(),
                teamMatchEntity.getParticipants()
                        .stream()
                        .map(teamMapper::toDomain)
                        .collect(Collectors.toList()),
                teamMatchEntity.getCreatedAt(),
                teamMatchEntity.getUpdatedAt(),
                teamMatchEntity.getMatchInfo()
        );
    }
    public TeamMatchEntity toEntity(TeamMatch teamMatch){
        return new TeamMatchEntity(
                teamMatch.id(),
                teamMatch.name(),
                teamMatch.participants()
                        .stream()
                        .map(teamMapper::toEntity)
                        .collect(Collectors.toList()),
                teamMatch.createdAt(),
                teamMatch.updatedAt(), teamMatch.matchInfo()
        );
    }
}
