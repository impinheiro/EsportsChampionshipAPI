package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record PlayerRanking(String id, Championship championship, List<PlayerScore> scores) {
}
