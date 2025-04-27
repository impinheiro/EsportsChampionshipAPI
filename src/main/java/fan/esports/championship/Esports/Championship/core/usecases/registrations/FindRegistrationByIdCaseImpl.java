package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class FindRegistrationByIdCaseImpl implements FindRegistrationByIdCase {
    private final RegistrationGateway registrationGateway;

    public FindRegistrationByIdCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public Registration execute(String id) {
        return registrationGateway.findById(id).orElse(null);
    }
}
