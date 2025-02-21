package fan.esports.championship.Esports.Championship.infrastructure.persistence.championship;

import fan.esports.championship.Esports.Championship.core.domain.Registrations;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "championships")
public class ChampionshipEntity {

    @Id
    private String id;
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
    private List<MatchEntity> matches;
    private List<Registrations> registrations;

    public ChampionshipEntity() {
    }

    public ChampionshipEntity(String id, String name, String gameName, ChampionshipType type, Integer capacity, double subscriptionValue, ChampionshipFormat format, String rules, LocalDateTime startDate, LocalDateTime endDate, String location, String coverImage, String logoImage, String awardDescription) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ChampionshipEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gameName='" + gameName + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                ", subscriptionValue=" + subscriptionValue +
                ", format=" + format +
                ", rules='" + rules + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", logoImage='" + logoImage + '\'' +
                ", awardDescription='" + awardDescription + '\'' +
                '}';
    }
}
