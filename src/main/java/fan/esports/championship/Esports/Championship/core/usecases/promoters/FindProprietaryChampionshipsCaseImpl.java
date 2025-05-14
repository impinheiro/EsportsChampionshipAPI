package fan.esports.championship.Esports.Championship.core.usecases.promoters;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.PromoterGateway;

import java.util.List;

public class FindProprietaryChampionshipsCaseImpl implements FindProprietaryChampionshipsCase {

    private final PromoterGateway promoterGateway;

    public FindProprietaryChampionshipsCaseImpl(PromoterGateway promoterGateway) {
        this.promoterGateway = promoterGateway;
    }

    @Override
    public List<Championship> execute() {
        return promoterGateway.findProprietaryChampionships();
    }
}
