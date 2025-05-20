package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.domain.MatchResults;
import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.enums.MatchStatus;

import java.time.LocalDateTime;
import java.util.List;

public record MatchDTO(String id,
                       String name,
                       List<String> registrationsId,
                       String championshipId,
                       LocalDateTime date,
                       MatchStatus status,
                       List<MatchResults> results,
                       LocalDateTime createdAt,
                       LocalDateTime updatedAt) {
}
