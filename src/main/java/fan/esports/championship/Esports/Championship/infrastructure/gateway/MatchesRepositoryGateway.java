package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.enums.MatchStatus;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.matches.MatchEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MatchesRepositoryGateway implements MatchGateway {

    private final MatchRepository matchRepository;
    private final MatchEntityMapper matchEntityMapper;

    public MatchesRepositoryGateway(MatchRepository matchRepository, MatchEntityMapper matchEntityMapper) {
        this.matchRepository = matchRepository;
        this.matchEntityMapper = matchEntityMapper;
    }


    @Override
    public Match create(Match match) {
        MatchEntity matchEntity = matchEntityMapper.toEntity(match);

        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        matchEntity.setMatchResults(new ArrayList<>());

        matchRepository.save(matchEntity);

        return matchEntityMapper.toDomain(matchEntity);
    }

    @Override
    public Match update(String id, Match match) {

        MatchEntity databaseMatch = matchRepository.findById(id).orElse(null);

        MatchEntity updatedData = matchEntityMapper.toEntity(match);

        databaseMatch.setMatchResults(updatedData.getMatchResults());
        databaseMatch.setStatus(MatchStatus.FINISHED);
        databaseMatch.setUpdatedAt(LocalDateTime.now());

        matchRepository.save(databaseMatch);

        return matchEntityMapper.toDomain(databaseMatch);
    }

    @Override
    public void delete(String id) {
        MatchEntity matchToBeDeleted = matchRepository.findById(id).orElse(null);
        matchRepository.delete(matchToBeDeleted);
    }

    @Override
    public Optional<Match> findById(String id) {
        MatchEntity matchEntity = matchRepository.findById(id).orElse(null);
        if (matchEntity != null) {
            return Optional.of(matchEntityMapper.toDomain(matchEntity));
        }
        return Optional.empty();
    }

    @Override
    public List<Match> findAll() {
        List<MatchEntity> matches = matchRepository.findAll();
        return matches
                .stream()
                .map(matchEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

}
