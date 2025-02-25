package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

import java.util.ArrayList;
import java.util.List;

public record Team(String id, String name, List<User> members){
    public Team {
        if (members == null) {
            members = new ArrayList<>();
        }
    }
}
