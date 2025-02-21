package fan.esports.championship.Esports.Championship.infrastructure.persistence.championship;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends MongoRepository<ChampionshipEntity, String> {
}
