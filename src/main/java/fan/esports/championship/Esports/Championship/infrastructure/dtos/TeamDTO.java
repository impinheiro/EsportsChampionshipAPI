package fan.esports.championship.Esports.Championship.infrastructure.dtos;


import java.time.LocalDateTime;
import java.util.List;

public record TeamDTO(String id, String name, List<UserDTO> members, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
