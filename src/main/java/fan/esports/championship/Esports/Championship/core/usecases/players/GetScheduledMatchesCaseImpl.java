package fan.esports.championship.Esports.Championship.core.usecases.players;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetScheduledMatchesCaseImpl implements GetScheduledMatchesCase {

    private final UserGateway userGateway;
    private final RegistrationGateway registrationGateway;
    private final MatchGateway matchGateway;

    public GetScheduledMatchesCaseImpl(UserGateway userGateway, RegistrationGateway registrationGateway, MatchGateway matchGateway) {
        this.userGateway = userGateway;
        this.registrationGateway = registrationGateway;
        this.matchGateway = matchGateway;
    }

    @Override
    public List<Match> execute() {
        String authenticatedUserId = userGateway.getAuthenticatedUser().id();

        List<Registration> userRegistrations = registrationGateway.findAll()
                .stream()
                .filter(registration -> registration.ownerId().equals(authenticatedUserId))
                .collect(Collectors.toList()
                );

        Set<String> registrationsIds = userRegistrations
                .stream()
                .map(Registration::id)
                .collect(Collectors.toSet()
                );

        List<Match> upcomingMatches = matchGateway.findAll().stream()
                .filter(match -> match.date().isAfter(LocalDateTime.now()))
                .toList();

        List<Match> userScheduledMatches = upcomingMatches.stream()
                .filter(match -> match.registrationsId().stream()
                        .anyMatch(registrationsIds::contains))
                .collect(Collectors.toList()
                );
        return userScheduledMatches;
    }
}
