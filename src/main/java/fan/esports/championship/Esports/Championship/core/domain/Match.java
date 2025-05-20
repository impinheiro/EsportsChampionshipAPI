package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.enums.MatchStatus;

import java.time.LocalDateTime;
import java.util.List;

public record Match(String id,
                    String name,
                    List<String>registrationsId,
                    String championshipId,
                    LocalDateTime date,
                    MatchStatus status,
                    List<MatchResults> results,
                    LocalDateTime createdAt,
                    LocalDateTime updatedAt) {
}
