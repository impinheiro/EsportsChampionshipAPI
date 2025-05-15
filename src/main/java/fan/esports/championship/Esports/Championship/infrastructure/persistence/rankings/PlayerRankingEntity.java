package fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings;

import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.scores.PlayerScoreEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "player-ranking")
public class PlayerRankingEntity {

    @Id
    private String id;
    private ChampionshipEntity championship;
    private List<PlayerScoreEntity> scores;

    public PlayerRankingEntity(String id, ChampionshipEntity championship, List<PlayerScoreEntity> scores) {
        this.id = id;
        this.championship = championship;
        this.scores = scores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChampionshipEntity getChampionship() {
        return championship;
    }

    public void setChampionship(ChampionshipEntity championship) {
        this.championship = championship;
    }

    public List<PlayerScoreEntity> getScores() {
        return scores;
    }

    public void setScores(List<PlayerScoreEntity> scores) {
        this.scores = scores;
    }
}
