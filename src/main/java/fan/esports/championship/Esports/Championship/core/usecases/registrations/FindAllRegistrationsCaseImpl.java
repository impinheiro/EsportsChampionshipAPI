package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;


import java.util.List;
import java.util.Map;

public class FindAllRegistrationsCaseImpl implements FindAllRegistrationsCase {

    private final RegistrationGateway registrationGateway;

    public FindAllRegistrationsCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public List<Registration> execute() {
        return registrationGateway.findAll();
    }
}
