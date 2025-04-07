package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import java.util.List;

public record MatchesDTO<T>(String id, String name, List<T> participants) {
}
