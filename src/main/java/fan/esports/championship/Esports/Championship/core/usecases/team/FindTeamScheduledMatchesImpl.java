package fan.esports.championship.Esports.Championship.core.usecases.team;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindTeamScheduledMatchesImpl implements FindTeamScheduledMatches {

    private final RegistrationGateway registrationGateway;
    private final MatchGateway matchGateway;

    public FindTeamScheduledMatchesImpl(RegistrationGateway registrationGateway, MatchGateway matchGateway) {
        this.registrationGateway = registrationGateway;
        this.matchGateway = matchGateway;
    }

    @Override
    public List<Match> execute(String teamId) {

        List<Registration> registrations = registrationGateway.findAll()
                .stream()
                .filter(registration -> registration.ownerId().equals(teamId))
                .collect(Collectors.toList()
                );

        Set<String> registrationsIds = registrations
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
