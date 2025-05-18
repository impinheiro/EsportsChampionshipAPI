package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record Ranking(
        String id,
        String championshipId,
        List<Score> scores) {
}
