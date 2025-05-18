package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.RankingEntity;
import org.springframework.stereotype.Component;

@Component
public class RankingEntityMapper {

    public RankingEntity toEntity(Ranking playerRanking) {
        return new RankingEntity(
                playerRanking.id(),
                playerRanking.championshipId(),
                playerRanking.scores()
        );
    }

    public Ranking toDomain(RankingEntity rankingEntity) {
        return new Ranking(
                rankingEntity.getId(),
                rankingEntity.getChampionshipId(),
                rankingEntity.getScores()
        );
    }

}
