package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

public class DeleteRegistrationCaseImpl implements DeleteRegistrationCase {
    private final RegistrationGateway registrationGateway;

    public DeleteRegistrationCaseImpl(RegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    @Override
    public void execute(String id) {
        registrationGateway.delete(id);
    }
}
