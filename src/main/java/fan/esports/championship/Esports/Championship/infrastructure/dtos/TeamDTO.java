package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import java.util.List;

public record TeamDTO(String id, String name, List<UserDTO> members) {
}
