package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class UpdateRegistrationCaseImpl implements UpdateRegistrationCase {
    private final RegistrationGateway registrationGateway;

    public UpdateRegistrationCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public Registration execute(String id, Registration registration) {
        return registrationGateway.update(id, registration);
    }
}
