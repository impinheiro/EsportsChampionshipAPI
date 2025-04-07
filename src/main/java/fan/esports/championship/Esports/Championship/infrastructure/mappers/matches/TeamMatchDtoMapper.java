package fan.esports.championship.Esports.Championship.infrastructure.mappers.matches;

import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamMatchDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamDtoMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeamMatchDtoMapper {

    private final TeamDtoMapper teamMapper;

    public TeamMatchDtoMapper(TeamDtoMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    public  TeamMatch toDomain(TeamMatchDTO teamMatchDTO){
        return new TeamMatch(
                teamMatchDTO.id(),
                teamMatchDTO.name(),
                teamMatchDTO.participants()
                        .stream()
                        .map(teamMapper::toDomain)
                        .collect(Collectors.toList()),
                teamMatchDTO.createdAt(),
                teamMatchDTO.updatedAt(),
                teamMatchDTO.matchInfo()
        );
    }

    public TeamMatchDTO toDTO(TeamMatch teamMatch){
        return new TeamMatchDTO(
                teamMatch.id(),
                teamMatch.name(),
                teamMatch.participants()
                        .stream()
                        .map(teamMapper::toDTO)
                        .collect(Collectors.toList()),
                teamMatch.createdAt(),
                teamMatch.updatedAt(),
                teamMatch.matchInfo()
        );
    }
}
