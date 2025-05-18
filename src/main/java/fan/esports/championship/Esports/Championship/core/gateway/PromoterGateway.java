package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;

import java.util.List;

public interface PromoterGateway {

    List<Registration> findPendingRegistrations();
    List<Championship> findProprietaryChampionships();
    void manageRegistration(String registrationId, String status);
}
