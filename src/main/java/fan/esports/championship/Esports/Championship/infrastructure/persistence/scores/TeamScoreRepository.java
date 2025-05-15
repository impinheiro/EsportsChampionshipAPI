package fan.esports.championship.Esports.Championship.infrastructure.persistence.scores;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamScoreRepository extends MongoRepository<TeamScoreEntity, String> {
}
