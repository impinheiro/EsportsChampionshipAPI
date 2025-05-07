package fan.esports.championship.Esports.Championship.core.usecases.promoters;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindPendingTeamRegistrationsCaseImpl implements FindPendingTeamRegistrationsCase {
    private final ChampionshipGateway championshipGateway;
    private final UserGateway userGateway;
    private final RegistrationGateway registrationGateway;

    public FindPendingTeamRegistrationsCaseImpl(ChampionshipGateway championshipGateway, UserGateway userGateway, RegistrationGateway registrationGateway) {
        this.championshipGateway = championshipGateway;
        this.userGateway = userGateway;
        this.registrationGateway = registrationGateway;
    }

    @Override
    public List<TeamRegistration> execute() {
        String authenticatedId = userGateway.getAuthenticatedUser().id().replaceAll("^\"|\"$", "");
        List<Championship> championships = championshipGateway.findAll()
                .stream()
                .filter(championship -> championship.createdBy().equals(authenticatedId))
                .collect(Collectors.toList()
                );
        List<TeamRegistration> registrations = championships.stream()
                .flatMap(championship -> championship.registrationsId().stream())
                .map(registrationGateway::findTeamRegistrationById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(registration -> registration.status().name().equals(RegistrationStatus.PENDING.name()))
                .toList();
        return registrations;
    }
}
