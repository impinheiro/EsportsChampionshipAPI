package fan.esports.championship.Esports.Championship.infrastructure.persistence.scores;

import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team-scores")
public class TeamScoreEntity {

    @Id
    private String id;
    private TeamEntity team;
    private int score;

    public TeamScoreEntity(String id, TeamEntity team, int score) {
        this.id = id;
        this.team = team;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
