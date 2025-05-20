package fan.esports.championship.Esports.Championship.infrastructure.persistence.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChampionshipRepository extends MongoRepository<ChampionshipEntity, String> {
    List<ChampionshipEntity> findByGameName(String gameName);
    List<ChampionshipEntity> findByFormat(String format);
    List<ChampionshipEntity> findByType(String type);
}
