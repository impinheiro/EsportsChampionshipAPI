package fan.esports.championship.Esports.Championship.infrastructure.persistence.registration;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teamregistrations")
public class TeamRegistrationEntity {
    @Id
    private String id;
    private TeamEntity team;
    private RegistrationStatus status;

    public TeamRegistrationEntity() {

    }

    public TeamRegistrationEntity(String id, TeamEntity team, RegistrationStatus status) {
        this.id = id;
        this.team = team;
        this.status = status;
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

    public RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TeamRegistrationEntity{" +
                "id='" + id + '\'' +
                ", team=" + team +
                '}';
    }
}
