package fan.esports.championship.Esports.Championship.infrastructure.persistence.match;


import fan.esports.championship.Esports.Championship.core.domain.MatchResults;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "matches")
public class MatchEntity{

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<UserEntity> participants;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private MatchResults matchResults;

    public MatchEntity() {
    }

    public MatchEntity(String id, String name, List<UserEntity> participants, LocalDateTime createdAt, LocalDateTime updatedAt, MatchResults matchResults) {
        this.id = id;
        this.name = name;
        this.participants = participants;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.matchResults = matchResults;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserEntity> participants) {
        this.participants = participants;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MatchResults getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(MatchResults matchResults) {
        this.matchResults = matchResults;
    }
}
