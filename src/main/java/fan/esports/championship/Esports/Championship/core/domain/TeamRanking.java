package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record TeamRanking(
        String id,
        String championshipId,
        List<TeamScore> scores) {
}
