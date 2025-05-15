package fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings;

import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.scores.TeamScoreEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "team-ranking")
public class TeamRankingEntity {

    @Id
    private String id;
    private ChampionshipEntity championship;
    private List<TeamScoreEntity> scores;

    public TeamRankingEntity(String id, ChampionshipEntity championship, List<TeamScoreEntity> scores) {
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

    public List<TeamScoreEntity> getScores() {
        return scores;
    }

    public void setScores(List<TeamScoreEntity> scores) {
        this.scores = scores;
    }
}
