package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record Match<T>(String id, String name, List<T> participants) {
}
