package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class UpdateTeamRegistrationCaseImpl implements UpdateTeamRegistrationCase {
    private final RegistrationGateway registrationGateway;

    public UpdateTeamRegistrationCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public TeamRegistration execute(String id, TeamRegistration teamRegistration) {
        return registrationGateway.updateTeamRegistration(id, teamRegistration);
    }
}
