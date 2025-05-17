package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionShipEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.PlayerRankingEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlayerRankingEntityMapper {

    public PlayerRankingEntity toEntity(PlayerRanking playerRanking) {
        return new PlayerRankingEntity(
                playerRanking.id(),
                playerRanking.championshipId(),
                playerRanking.scores()
        );
    }

    public PlayerRanking toDomain(PlayerRankingEntity playerRankingEntity) {
        return new PlayerRanking(
                playerRankingEntity.getId(),
                playerRankingEntity.getChampionshipId(),
                playerRankingEntity.getScores()
        );
    }

}
