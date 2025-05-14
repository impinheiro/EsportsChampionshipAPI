package fan.esports.championship.Esports.Championship.core.usecases.promoters;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.PromoterGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

import java.util.List;
import java.util.stream.Collectors;

public class ChangeRegistrationsStatusCaseImpl implements ChangeRegistrationsStatusCase {

    private final PromoterGateway promoterGateway;

    public ChangeRegistrationsStatusCaseImpl(PromoterGateway promoterGateway) {
        this.promoterGateway = promoterGateway;
    }

    @Override
    public void execute(String registrationId, String status) {
        promoterGateway.manageRegistration(registrationId, status);
    }
}
