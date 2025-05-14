package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import java.util.List;

public record TeamData(String id, String name, List<UserData> players) {
}
