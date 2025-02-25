package fan.esports.championship.Esports.Championship.infrastructure.persistence.team;

import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "teams")
public class TeamEntity {

    @Id
    private String id;
    private String name;
    private List<UserEntity> members;

    public TeamEntity() {

    }

    public TeamEntity(String id, String name, List<UserEntity> members) {
        this.id = id;
        this.name = name;
        this.members = members == null ? new ArrayList<>() : members;
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

    public List<UserEntity> getMembers() {
        return members;
    }

    public void setMembers(List<UserEntity> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
