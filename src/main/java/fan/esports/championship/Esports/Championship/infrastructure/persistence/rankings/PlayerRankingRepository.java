package fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRankingRepository extends MongoRepository<PlayerRankingEntity, String> {
}
