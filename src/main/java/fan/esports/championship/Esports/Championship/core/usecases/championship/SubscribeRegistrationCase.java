package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;

public interface SubscribeRegistrationCase {
    Championship execute(String championshipId, String registrationId);
}
