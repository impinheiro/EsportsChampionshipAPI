package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.PlayerRankingDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewPlayerRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionshipDtoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.players.PlayerScoreDtoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.PlayerRankingEntity;

import java.util.stream.Collectors;

public class PlayerRankingDtoMapper {
    private ChampionshipDtoMapper championshipDtoMapper;
    private PlayerScoreDtoMapper playerScoreDtoMapper;

    public PlayerRanking toDomain(NewPlayerRanking playerRanking) {
        return new PlayerRanking(
                playerRanking.id(),
                championshipDtoMapper.toDomain(playerRanking.championship()),
                null
        );
    }

    public PlayerRankingDTO toDto(PlayerRanking playerRanking) {
        return new PlayerRankingDTO(
                playerRanking.id(),
                championshipDtoMapper.toDto(playerRanking.championship()),
                playerRanking.scores()
                        .stream()
                        .map(playerScoreDtoMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }
}
