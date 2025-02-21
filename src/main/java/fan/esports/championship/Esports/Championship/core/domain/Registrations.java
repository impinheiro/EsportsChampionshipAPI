package fan.esports.championship.Esports.Championship.core.domain;

import java.util.List;

public record Registrations(String id, String name, List<User> members, List<Team> teams) {
}
