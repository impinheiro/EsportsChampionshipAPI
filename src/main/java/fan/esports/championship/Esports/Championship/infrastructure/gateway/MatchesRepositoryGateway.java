package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.usecases.matches.UpdateMatchCase;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MatchesRepositoryGateway implements MatchGateway {

    private final MatchRepository matchRepository;

    public MatchesRepositoryGateway(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match create(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match update(String id, Match match) {
        MatchEntity matchToBeUpdated = matchRepository.findById(id).orElse(null);
        return matchRepository.save(matchToBeUpdated);
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
            return Optional.of(matchEntity);
        }
        return Optional.empty();
    }

    @Override
    public List<Match> findAll() {
        return matchRepository.findAll();
    }
}
