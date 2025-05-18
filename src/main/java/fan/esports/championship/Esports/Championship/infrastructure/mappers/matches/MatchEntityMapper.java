package fan.esports.championship.Esports.Championship.infrastructure.mappers.matches;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MatchEntityMapper {

    private final UserEntityMapper userMapper;

    public MatchEntityMapper(UserEntityMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Match toDomain(MatchEntity matchEntity){
        return new Match(
                matchEntity.getId(),
                matchEntity.getName(),
                matchEntity.getParticipantsId(),
                matchEntity.getMatchDate(),
                matchEntity.getStatus(),
                matchEntity.getMatchResults(),
                matchEntity.getCreatedAt(),
                matchEntity.getUpdatedAt()
        );
    }
    public MatchEntity toEntity(Match match){
        return new MatchEntity(
                match.id(),
                match.name(),
                match.participantsId(),
                match.date(),
                match.status(),
                match.results(),
                match.createdAt(),
                match.updatedAt()
        );
    }
}
