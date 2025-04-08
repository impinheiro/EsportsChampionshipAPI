package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class CreateTeamRegistrationCaseImpl implements CreateTeamRegistrationCase {
    private final RegistrationGateway registrationGateway;

    public CreateTeamRegistrationCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public TeamRegistration execute(TeamRegistration teamRegistration) {
        return registrationGateway.createTeamRegistration(teamRegistration);
    }
}
