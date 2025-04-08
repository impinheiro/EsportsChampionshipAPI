package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class DeleteTeamRegistrationCaseImpl implements DeleteTeamRegistrationCase {
    private final RegistrationGateway registrationGateway;

    public DeleteTeamRegistrationCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public void execute(String id) {
        registrationGateway.deleteTeamRegistration(id);
    }
}
