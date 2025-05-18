package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.domain.Score;

import java.util.List;

public record RankingDTO(
                    String id,
                    String championshipId,
                    List<Score> scores) {
}
