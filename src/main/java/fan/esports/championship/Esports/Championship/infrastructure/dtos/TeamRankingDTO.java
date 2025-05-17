package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;

import java.util.List;

public record TeamRankingDTO(
                    String id,
                    String championshipId,
                    List<TeamScore> scores) {
}
