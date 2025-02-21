package fan.esports.championship.Esports.Championship.infrastructure.persistence.match;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<MatchEntity, String> {
}
