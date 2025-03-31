package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Registration;

import java.util.Optional;

public interface RegistrationGateway {
    Registration create(Registration registration);
    Registration update(String id, Registration registration);
    Optional<Registration> findById(String id);
    void delete(String id);
}
