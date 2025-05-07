package fan.esports.championship.Esports.Championship.infrastructure.persistence.registration;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userregistrations")
public class RegistrationEntity {
    @Id
    private String id;
    private UserEntity user;
    private RegistrationStatus status;

    public RegistrationEntity() {
    }

    public RegistrationEntity(String id, UserEntity user, RegistrationStatus status) {
        this.id = id;
        this.user = user;
        this.status = status;
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

    public RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegistrationEntity{" +
                "id='" + id + '\'' +
                ", user=" + user +
                '}';
    }
}
