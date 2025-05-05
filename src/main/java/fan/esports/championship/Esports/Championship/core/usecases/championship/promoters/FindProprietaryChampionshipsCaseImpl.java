package fan.esports.championship.Esports.Championship.core.usecases.championship.promoters;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

import java.util.List;
import java.util.stream.Collectors;

public class FindProprietaryChampionshipsCaseImpl implements FindProprietaryChampionshipsCase {
    private final ChampionshipGateway championshipGateway;
    private final UserGateway userGateway;

    public FindProprietaryChampionshipsCaseImpl(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        this.championshipGateway = championshipGateway;
        this.userGateway = userGateway;
    }

    @Override
    public List<Championship> execute() {
        String authenticatedId = userGateway.getAuthenticatedUser().id().replaceAll("^\"|\"$","");
        List<Championship> allChampionships = championshipGateway.findAll();
        return allChampionships
                .stream()
                .filter( c -> c.createdBy().equals(authenticatedId))
                .collect(Collectors.toList()
                );
    }
}
