package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

import java.util.List;

public interface PromoterGateway {

    List<Registration> findPendingRegistrations();
    List<TeamRegistration> findPendingTeamRegistrations();
    List<Championship> findProprietaryChampionships();
    void manageRegistration(String registrationId, String status);
}
