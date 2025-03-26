package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegistrationRepositoryGateway implements RegistrationGateway {

    @Override
    public Registration create(Registration registration) {
        return null;
    }

    @Override
    public Registration update(String id, Registration registration) {
        return null;
    }

    @Override
    public Optional<Registration> findById(String id) {
        return Optional.empty();
    }
}
