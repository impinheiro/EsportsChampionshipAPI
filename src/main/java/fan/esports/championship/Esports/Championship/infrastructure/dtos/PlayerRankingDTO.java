package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import java.util.List;

public record PlayerRankingDTO(String id, ChampionshipDTO championship, List<PlayerScoreDTO> scores) {
}
