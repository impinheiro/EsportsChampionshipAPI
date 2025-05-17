package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.PlayerRankingDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewRanking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PlayerRankingDtoMapper {


    public PlayerRanking toDomain(NewRanking playerRanking) {
        return new PlayerRanking(
                playerRanking.id(),
                playerRanking.championshipId(),
                new ArrayList<>()
        );
    }

    public PlayerRankingDTO toDto(PlayerRanking playerRanking) {
        return new PlayerRankingDTO(
                playerRanking.id(),
                playerRanking.championshipId(),
                playerRanking.scores()
        );
    }

    public PlayerRanking toDomain(PlayerRankingDTO dto) {
        return new PlayerRanking(
                dto.id(),
                dto.championshipId(),
                dto.scores()
        );
    }
}
