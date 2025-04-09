package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;


import java.util.Map;

public class FindAllRegistrationsCaseImpl implements FindAllRegistrationsCase {
    private final RegistrationGateway registrationGateway;

    public FindAllRegistrationsCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public Map<String, Object> execute() {
        return registrationGateway.findAll();
    }
}
