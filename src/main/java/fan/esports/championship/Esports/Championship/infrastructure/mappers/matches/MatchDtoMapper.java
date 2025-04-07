package fan.esports.championship.Esports.Championship.infrastructure.mappers.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.MatchDTO;

public class MatchDtoMapper {

    public Match toDomain(MatchDTO matchesDTO){
        return new Match(matchesDTO.id(), matchesDTO.name(), matchesDTO.participants());
    }
    public MatchDTO toDTO(Match match){
        return new MatchDTO(match.id(), match.name(), match.participants());
    }
}
