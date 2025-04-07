package fan.esports.championship.Esports.Championship.infrastructure.mappers.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchEntity;

public class MatchEntityMapper {

    public Match toDomain(MatchEntity matchEntity){
        return new Match(matchEntity.getId(), matchEntity.getName(),matchEntity.getParticipants());
    }
    public MatchEntity toEntity(Match match){
        return new MatchEntity(match.id(), match.name(),match.participants());
    }
}
