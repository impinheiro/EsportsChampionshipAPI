package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;

import java.util.Optional;

public interface RegistrationGateway {
    Registration create(Registration registration);
    Registration update(String id, Registration registration);
    Optional<Registration> findById(String id);
    void delete(String id);
    TeamRegistration createTeamRegistration(TeamRegistration teamRegistration);
    TeamRegistration updateTeamRegistration(String id, TeamRegistration teamRegistration);
    Optional<TeamRegistration> findTeamRegistrationById(String id);
    void deleteTeamRegistration(String id);
}
