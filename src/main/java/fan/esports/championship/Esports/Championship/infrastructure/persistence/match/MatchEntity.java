package fan.esports.championship.Esports.Championship.infrastructure.persistence.match;


import fan.esports.championship.Esports.Championship.core.domain.MatchResults;
import fan.esports.championship.Esports.Championship.core.enums.MatchStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "matches")
public class MatchEntity{

    @Id
    private String id;
    private String name;
    private List<String> registrationsId;
    private String championshipId;
    private LocalDateTime matchDate;
    private MatchStatus status;
    private List<MatchResults> matchResults;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MatchEntity() {
    }

    public MatchEntity(String id, String name, List<String> registrationsId, String championshipId, LocalDateTime matchDate, MatchStatus status, List<MatchResults> matchResults, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.registrationsId = registrationsId;
        this.championshipId = championshipId;
        this.matchDate = matchDate;
        this.status = status;
        this.matchResults = matchResults;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public List<String> getRegistrationsId() {
        return registrationsId;
    }

    public void setRegistrationsId(List<String> registrationsId) {
        this.registrationsId = registrationsId;
    }

    public String getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(String championshipId) {
        this.championshipId = championshipId;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public List<MatchResults> getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(List<MatchResults> matchResults) {
        this.matchResults = matchResults;
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
}
