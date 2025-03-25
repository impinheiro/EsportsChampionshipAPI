package fan.esports.championship.Esports.Championship.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public record Team(String id, String name, List<User> members, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
