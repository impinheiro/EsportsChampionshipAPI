package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public record MatchDTO(String id, String name, List<UserDTO> participants, LocalDateTime createdAt, LocalDateTime updatedAt, String matchInfo) {
}
