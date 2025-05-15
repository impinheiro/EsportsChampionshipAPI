package fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.players;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.scores.PlayerScoreEntity;

public class PlayerScoreEntityMapper {
    private UserEntityMapper userEntityMapper;

    public PlayerScoreEntity toEntity(PlayerScore playerScore) {
        return new PlayerScoreEntity(
                playerScore.id(),
                userEntityMapper.toEntity(playerScore.player()),
                playerScore.score()
        );
    }

    public PlayerScore toDomain(PlayerScoreEntity playerScoreEntity) {
        return new PlayerScore(
                playerScoreEntity.getId(),
                userEntityMapper.toDomain(playerScoreEntity.getUser()),
                playerScoreEntity.getScore()
        );
    }
}
