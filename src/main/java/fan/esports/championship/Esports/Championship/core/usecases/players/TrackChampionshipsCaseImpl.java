package fan.esports.championship.Esports.Championship.core.usecases.players;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrackChampionshipsCaseImpl implements TrackChampionshipsCase {

    private final UserGateway userGateway;
    private final ChampionshipGateway championshipGateway;
    private final RegistrationGateway registrationGateway;

    public TrackChampionshipsCaseImpl(UserGateway userGateway, ChampionshipGateway championshipGateway, RegistrationGateway registrationGateway) {
        this.userGateway = userGateway;
        this.championshipGateway = championshipGateway;
        this.registrationGateway = registrationGateway;
    }

    @Override
    public Map<Registration, Championship> execute() {
        String authenticatedUserId = userGateway.getAuthenticatedUser().id();
        List<Registration> ownedRegistrations = registrationGateway.findAll()
                .stream()
                .filter(registration -> registration.ownerId()
                        .equals(authenticatedUserId)).collect(Collectors.toList()
                );
        Map<Registration, Championship> trackedChampionships = ownedRegistrations.stream().
                collect(Collectors.toMap(Function.identity(),
                        registration -> championshipGateway.findById(registration.championshipId()).orElse(null))
                );
        return trackedChampionships;
    }
}
