package fan.esports.championship.Esports.Championship.infrastructure.mappers.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.MatchDTO;
import org.springframework.stereotype.Component;


@Component
public class MatchDtoMapper {

    public Match toDomain(MatchDTO matchesDTO){
        return new Match(
                matchesDTO.id(),
                matchesDTO.name(),
                matchesDTO.registrationsId(),
                matchesDTO.championshipId(),
                matchesDTO.date(),
                matchesDTO.status(),
                matchesDTO.results(),
                matchesDTO.createdAt(),
                matchesDTO.updatedAt()
        );
    }

    public MatchDTO toDTO(Match match){
        return new MatchDTO(
                match.id(),
                match.name(),
                match.registrationsId(),
                match.championshipId(),
                match.date(),
                match.status(),
                match.results(),
                match.createdAt(),
                match.updatedAt()

        );
    }

}
