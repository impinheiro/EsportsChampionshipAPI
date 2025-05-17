package fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "team-ranking")
public class TeamRankingEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String championshipId;
    private List<TeamScore> scores;

    public TeamRankingEntity() {
    }

    public TeamRankingEntity(String id, String championshipId) {
        this.id = id;
        this.championshipId = championshipId;
    }

    public TeamRankingEntity(String id, String championshipId, List<TeamScore> scores) {
        this.id = id;
        this.championshipId = championshipId;
        this.scores = scores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(String championshipId) {
        this.championshipId = championshipId;
    }

    public List<TeamScore> getScores() {
        return scores;
    }

    public void setScores(List<TeamScore> scores) {
        this.scores = scores;
    }
}
