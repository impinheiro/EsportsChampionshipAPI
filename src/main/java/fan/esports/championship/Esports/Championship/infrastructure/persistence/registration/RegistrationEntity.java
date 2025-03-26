package fan.esports.championship.Esports.Championship.infrastructure.persistence.registration;

import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userregistrations")
public class RegistrationEntity {
    @Id
    private String id;
    private UserEntity user;

    public RegistrationEntity(UserEntity user, String id) {
        this.user = user;
        this.id = id;
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

    @Override
    public String toString() {
        return "RegistrationEntity{" +
                "id='" + id + '\'' +
                ", user=" + user +
                '}';
    }
}
