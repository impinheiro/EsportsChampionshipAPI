package fan.esports.championship.Esports.Championship.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public record Match(String id, String name,
                       List<User>participants, LocalDateTime createdAt,
                       LocalDateTime updatedAt, String matchInfo) {
}
