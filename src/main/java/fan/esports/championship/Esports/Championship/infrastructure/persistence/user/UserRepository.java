package fan.esports.championship.Esports.Championship.infrastructure.persistence.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByNickname(String nickname);
    Optional<UserDetails> findByEmail(String email);
}
