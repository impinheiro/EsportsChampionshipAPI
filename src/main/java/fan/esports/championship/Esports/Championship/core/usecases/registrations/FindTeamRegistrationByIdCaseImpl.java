package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;

public class FindTeamRegistrationByIdCaseImpl implements FindTeamRegistrationByIdCase {
    private final RegistrationGateway registrationGateway;

    public FindTeamRegistrationByIdCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public TeamRegistration execute(String id) {
        return registrationGateway.findTeamRegistrationById(id).orElse(null);
    }
}
