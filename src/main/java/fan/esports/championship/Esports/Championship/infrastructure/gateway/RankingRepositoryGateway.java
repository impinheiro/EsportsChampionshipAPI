package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.RankingEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.RankingEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.RankingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        RankingEntity foundRanking = rankingRepository.findById(id).orElse(null);

        RankingEntity updatedRanking = rankingEntityMapper.toEntity(playerRanking);

        updatedRanking.setScores(new ArrayList<>());

        rankingRepository.save(updatedRanking);

        return rankingEntityMapper.toDomain(updatedRanking);
    }

    @Override
    public void delete(String id) {

        RankingEntity foundRanking = rankingRepository.findById(id).orElse(null);

        rankingRepository.delete(foundRanking);

    }

}
