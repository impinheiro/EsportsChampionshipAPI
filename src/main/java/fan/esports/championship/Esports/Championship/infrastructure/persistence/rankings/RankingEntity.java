package fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings;

import fan.esports.championship.Esports.Championship.core.domain.Score;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ranking")
public class RankingEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String championshipId;
    private List<Score> scores;

    public RankingEntity() {
    }


    public RankingEntity(String id, String championshipId) {
        this.id = id;
        this.championshipId = championshipId;
    }

    public RankingEntity(String id, String championshipId, List<Score> scores) {
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

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

}
