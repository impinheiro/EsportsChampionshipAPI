package fan.esports.championship.Esports.Championship.infrastructure.persistence.scores;


import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "player-scores")
public class PlayerScoreEntity {

    private String id;
    private UserEntity user;
    private int score;

    public PlayerScoreEntity(String id, UserEntity user, int score) {
        this.id = id;
        this.user = user;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
