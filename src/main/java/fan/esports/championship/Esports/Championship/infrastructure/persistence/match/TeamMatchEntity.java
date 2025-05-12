package fan.esports.championship.Esports.Championship.infrastructure.persistence.match;

import fan.esports.championship.Esports.Championship.core.domain.MatchResults;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "team_matches")
public class TeamMatchEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<TeamEntity> participants;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private MatchResults matchResults;

    public TeamMatchEntity() {
    }

    public TeamMatchEntity(String id, String name, List<TeamEntity> participants, LocalDateTime createdAt, LocalDateTime updatedAt, MatchResults matchResults) {
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

    public List<TeamEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<TeamEntity> participants) {
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
