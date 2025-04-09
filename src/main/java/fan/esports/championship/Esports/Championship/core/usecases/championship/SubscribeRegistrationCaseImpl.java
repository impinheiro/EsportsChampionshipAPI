package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.infrastructure.exceptions.RegistrationNotFoundException;

public class SubscribeRegistrationCaseImpl implements SubscribeRegistrationCase {
    private final ChampionshipGateway championshipGateway;
    private final RegistrationGateway registrationGateway;

    public SubscribeRegistrationCaseImpl(ChampionshipGateway championshipGateway, RegistrationGateway registrationGateway) {
        this.championshipGateway = championshipGateway;
        this.registrationGateway = registrationGateway;
    }

    @Override
    public Championship execute(String championshipId, String registrationId) {
        if(!registrationGateway.findById(registrationId).isPresent() && !registrationGateway.findTeamRegistrationById(registrationId).isPresent()) {
            throw new RegistrationNotFoundException("Invalid registration");
        }
        return championshipGateway.subscribeRegistration(championshipId, registrationId);
    }
}
