package fan.esports.championship.Esports.Championship.core.usecases.promoters;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.PromoterGateway;

import java.util.List;

public class FindPendingRegistrationsCaseImpl implements FindPendingRegistrationsCase {

    private final PromoterGateway promoterGateway;

    public FindPendingRegistrationsCaseImpl(PromoterGateway promoterGateway) {
        this.promoterGateway = promoterGateway;
    }

    @Override
    public List<Registration> execute() {
        return promoterGateway.findPendingRegistrations();
    }
}
