package fan.esports.championship.Esports.Championship.core.usecases.promoters;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.gateway.PromoterGateway;

import java.util.List;

public class FindPendingTeamRegistrationsCaseImpl implements FindPendingTeamRegistrationsCase {

    private final PromoterGateway promoterGateway;

    public FindPendingTeamRegistrationsCaseImpl(PromoterGateway promoterGateway) {
        this.promoterGateway = promoterGateway;
    }


    @Override
    public List<TeamRegistration> execute() {
        return promoterGateway.findPendingTeamRegistrations();
    }
}
