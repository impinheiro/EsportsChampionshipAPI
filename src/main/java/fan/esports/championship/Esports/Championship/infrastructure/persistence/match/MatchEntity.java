package fan.esports.championship.Esports.Championship.infrastructure.persistence.match;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "matches")
public class MatchEntity<T> {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<T> participants;

    public MatchEntity(String id, String name, List<T> participants) {
        this.id = id;
        this.name = name;
        this.participants = participants;
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

    public List<T> getParticipants() {
        return participants;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "MatchEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", participants=" + participants +
                '}';
    }
}
