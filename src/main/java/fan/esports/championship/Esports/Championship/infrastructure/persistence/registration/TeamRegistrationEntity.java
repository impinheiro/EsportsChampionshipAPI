package fan.esports.championship.Esports.Championship.infrastructure.persistence.registration;

import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teamregistrations")
public class TeamRegistrationEntity {
    @Id
    private String id;
    private TeamEntity team;

    public TeamRegistrationEntity(String id, TeamEntity team) {
        this.id = id;
        this.team = team;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "TeamRegistrationEntity{" +
                "id='" + id + '\'' +
                ", team=" + team +
                '}';
    }
}
