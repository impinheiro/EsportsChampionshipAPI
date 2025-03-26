package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class CreateRegistrationCaseImpl implements CreateRegistrationCase {
    private final RegistrationGateway registrationGateway;

    public CreateRegistrationCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public Registration execute(Registration registration) {
        return registrationGateway.create(registration);
    }
}
