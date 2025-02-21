package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record Match(String id, String name, List<User> members, List<Team> teams) {
}
