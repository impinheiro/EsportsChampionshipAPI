package fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.players;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.PlayerScoreDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserDtoMapper;

public class PlayerScoreDtoMapper {

    private UserDtoMapper userDtoMapper;

    public PlayerScore toDomain(PlayerScoreDTO playScoreDTO) {
        return  new PlayerScore(
                playScoreDTO.id(),
                userDtoMapper.toDomain(playScoreDTO.player()),
                playScoreDTO.score()
        );
    }

    public PlayerScoreDTO toDTO(PlayerScore playerScore) {
        return new PlayerScoreDTO(
                playerScore.id(),
                userDtoMapper.toDto(playerScore.player()),
                playerScore.score()
        );
    }
}
