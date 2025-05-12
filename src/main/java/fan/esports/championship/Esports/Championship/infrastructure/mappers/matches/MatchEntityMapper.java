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
                matchEntity.getParticipants()
                        .stream()
                        .map(userMapper::toDomain)
                        .collect(Collectors.toList()),
                matchEntity.getCreatedAt(),
                matchEntity.getUpdatedAt(),
                matchEntity.getMatchResults()
        );
    }
    public MatchEntity toEntity(Match match){
        return new MatchEntity(
                match.id(),
                match.name(),
                match.participants()
                        .stream()
                        .map(userMapper::toEntity)
                        .collect(Collectors.toList()),
                match.createdAt(),
                match.updatedAt(),
                match.matchResults()
        );
    }
}
