package fan.esports.championship.Esports.Championship.infrastructure.persistence.registration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<RegistrationEntity, String> {
}
