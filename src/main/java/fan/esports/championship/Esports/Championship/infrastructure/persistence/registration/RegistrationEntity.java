package fan.esports.championship.Esports.Championship.infrastructure.persistence.registration;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="registrations")
public class RegistrationEntity {
    @Id
    private String id;
    private String ownerdId;
    private String championshipId;
    private RegistrationStatus status;

    public RegistrationEntity() {
    }

    public RegistrationEntity(String id, String ownerdId, String championshipId, RegistrationStatus status) {
        this.id = id;
        this.ownerdId = ownerdId;
        this.championshipId = championshipId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerdId() {
        return ownerdId;
    }

    public void setOwnerdId(String ownerdId) {
        this.ownerdId = ownerdId;
    }

    public String getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(String championshipId) {
        this.championshipId = championshipId;
    }

    public RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }
}
