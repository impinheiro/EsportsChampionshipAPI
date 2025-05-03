package fan.esports.championship.Esports.Championship.infrastructure.persistence.championship;


import com.fasterxml.jackson.annotation.JsonIgnore;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "championships")
public class ChampionshipEntity {

    @Id
    private String id;
    @JsonIgnore
    private String createdBy;
    private String name;
    private String gameName;
    private ChampionshipType type;
    private Integer capacity;
    private double subscriptionValue;
    private ChampionshipFormat format;
    private String rules;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String coverImage;
    private String logoImage;
    private String awardDescription;
    private List<String> registrationsId;
    private List<String> matchesId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ChampionshipEntity() {

    }

    public ChampionshipEntity(String id, String createdBy, String name, String gameName, ChampionshipType type, Integer capacity, double subscriptionValue, ChampionshipFormat format, String rules, LocalDateTime startDate, LocalDateTime endDate, String location, String coverImage, String logoImage, String awardDescription, List<String> registrationsId, List<String> matchesId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdBy = createdBy;
        this.name = name;
        this.gameName = gameName;
        this.type = type;
        this.capacity = capacity;
        this.subscriptionValue = subscriptionValue;
        this.format = format;
        this.rules = rules;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.coverImage = coverImage;
        this.logoImage = logoImage;
        this.awardDescription = awardDescription;
        this.registrationsId = registrationsId;
        this.matchesId = matchesId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public ChampionshipType getType() {
        return type;
    }

    public void setType(ChampionshipType type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public double getSubscriptionValue() {
        return subscriptionValue;
    }

    public void setSubscriptionValue(double subscriptionValue) {
        this.subscriptionValue = subscriptionValue;
    }

    public ChampionshipFormat getFormat() {
        return format;
    }

    public void setFormat(ChampionshipFormat format) {
        this.format = format;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public String getAwardDescription() {
        return awardDescription;
    }

    public void setAwardDescription(String awardDescription) {
        this.awardDescription = awardDescription;
    }

    public List<String> getRegistrationsId() {
        return registrationsId;
    }

    public void setRegistrationsId(List<String> registrationsId) {
        this.registrationsId = registrationsId;
    }

    public List<String> getMatchesId() {
        return matchesId;
    }

    public void setMatchesId(List<String> matchesId) {
        this.matchesId = matchesId;
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
