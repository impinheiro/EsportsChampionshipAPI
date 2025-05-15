package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record TeamRanking(String id, Championship championship, List<TeamScore> scores) {
}
