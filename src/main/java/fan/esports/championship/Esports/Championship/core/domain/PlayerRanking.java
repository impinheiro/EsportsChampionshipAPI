package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record PlayerRanking(
        String id,
        String championshipId,
        List<PlayerScore> scores) {
}
