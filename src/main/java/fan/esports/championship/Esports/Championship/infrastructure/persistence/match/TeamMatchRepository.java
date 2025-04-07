package fan.esports.championship.Esports.Championship.infrastructure.persistence.match;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMatchRepository extends MongoRepository<TeamMatchEntity, String> {
}
