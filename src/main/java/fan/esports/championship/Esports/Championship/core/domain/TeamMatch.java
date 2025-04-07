package fan.esports.championship.Esports.Championship.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public record TeamMatch(String id, String name,
                        List<Team> participants, LocalDateTime createdAt,
                        LocalDateTime updatedAt, String matchInfo) {
}
