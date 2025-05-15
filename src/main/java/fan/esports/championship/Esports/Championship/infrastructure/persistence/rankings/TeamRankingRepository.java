package fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRankingRepository extends MongoRepository<TeamRankingEntity, String> {
}
