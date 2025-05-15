package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewPlayerRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionShipEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.players.PlayerScoreEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.PlayerRankingEntity;

import java.util.stream.Collectors;

public class PlayerRankingEntityMapper {

    private ChampionShipEntityMapper championShipEntityMapper;
    private PlayerScoreEntityMapper playerScoreEntityMapper;

    public PlayerRankingEntity toEntity(PlayerRanking playerRanking) {
        return new PlayerRankingEntity(
                playerRanking.id(),
                championShipEntityMapper.toEntity(playerRanking.championship()),
                playerRanking.scores()
                        .stream()
                        .map(playerScoreEntityMapper::toEntity)
                        .collect(Collectors.toList())
        );
    }

    public PlayerRanking toDomain(PlayerRankingEntity playerRankingEntity) {
        return new PlayerRanking(
                playerRankingEntity.getId(),
                championShipEntityMapper.toDomain(playerRankingEntity.getChampionship()),
                playerRankingEntity.getScores()
                        .stream()
                        .map(playerScoreEntityMapper::toDomain)
                        .collect(Collectors.toList())
        );
    }

}
