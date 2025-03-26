package fan.esports.championship.Esports.Championship.infrastructure.persistence.registration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRegistrationRepository extends MongoRepository<TeamRegistrationEntity, String> {
}
