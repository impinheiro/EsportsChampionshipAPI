package fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "player-ranking")
public class PlayerRankingEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String championshipId;
    private List<PlayerScore> scores;

    public PlayerRankingEntity() {
    }


    public PlayerRankingEntity(String id, String championshipId) {
        this.id = id;
        this.championshipId = championshipId;
    }

    public PlayerRankingEntity(String id, String championshipId, List<PlayerScore> scores) {
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

    public List<PlayerScore> getScores() {
        return scores;
    }

    public void setScores(List<PlayerScore> scores) {
        this.scores = scores;
    }

}
