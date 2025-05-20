package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.domain.Score;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.RankingEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.RankingEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.RankingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RankingRepositoryGateway implements RankingGateway {

    private final RankingEntityMapper rankingEntityMapper;
    private final RankingRepository rankingRepository;

    public RankingRepositoryGateway(RankingEntityMapper rankingEntityMapper, RankingRepository rankingRepository) {
        this.rankingEntityMapper = rankingEntityMapper;
        this.rankingRepository = rankingRepository;
    }


    @Override
    public Ranking createRanking(Ranking playerRanking) {
        RankingEntity newPlayerRanking = rankingEntityMapper.toEntity(playerRanking);
        newPlayerRanking.setScores(new ArrayList<>());
        rankingRepository.save(newPlayerRanking);
        return rankingEntityMapper.toDomain(newPlayerRanking);
    }

    @Override
    public Optional<Ranking> findById(String id) {
        RankingEntity rankingFound = rankingRepository.findById(id).orElse(null);
        if (rankingFound == null) {
            return Optional.empty();
        }
        return Optional.of(rankingEntityMapper.toDomain(rankingFound));
    }

    @Override
    public List<Ranking> findAll() {

        return rankingRepository.findAll()
                .stream()
                .map(rankingEntityMapper::toDomain)
                .collect(Collectors.toList()
                );
    }

    @Override
    public Ranking update(String id, Ranking playerRanking) {

        RankingEntity foundRanking = rankingRepository.findById(id).orElseThrow();


        RankingEntity updatedRanking = rankingEntityMapper.toEntity(playerRanking);


        List<Score> existingScores = foundRanking.getScores();


        List<Score> incomingScores = updatedRanking.getScores();

        // Transforma os existentes em mapa pra fácil acesso por ID
        Map<String, Score> scoreMap = existingScores.stream()
                .collect(Collectors.toMap(Score::participantId, Function.identity()));

        // Processa cada score novo
        for (Score newScore : incomingScores) {
            String participantId = newScore.participantId();
            Score existingScore = scoreMap.get(participantId);

            if (existingScore != null) {
                int updatedPoints = existingScore.points() + newScore.points();
                scoreMap.put(participantId, new Score(participantId, updatedPoints));
            } else {
                scoreMap.put(participantId, new Score(participantId, newScore.points()));
            }
        }

        List<Score> updatedScores = scoreMap.values().stream().toList();
        foundRanking.setScores(updatedScores);
        rankingRepository.save(foundRanking);

        return rankingEntityMapper.toDomain(foundRanking);
    }

    @Override
    public void delete(String id) {

        RankingEntity foundRanking = rankingRepository.findById(id).orElse(null);

        rankingRepository.delete(foundRanking);

    }

}
