package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class GetRegistrationByIdCaseImpl implements GetRegistrationByIdCase{
    private final RegistrationGateway registrationGateway;

    public GetRegistrationByIdCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public Registration execute(String id) {
        return registrationGateway.findById(id).orElse(null);
    }
}
