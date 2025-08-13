package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.PromoterGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionShipEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.championship.ChampionshipEntity;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PromoterRepositoryGateway implements PromoterGateway {

    private final UserRepositoryGateway userGateway;
    private final ChampionshipRepositoryGateway championshipGateway;
    private final RegistrationRepositoryGateway registrationGateway;
    private final ChampionShipEntityMapper championShipEntityMapper;

    public PromoterRepositoryGateway(UserRepositoryGateway userGateway, ChampionshipRepositoryGateway championshipGateway, RegistrationRepositoryGateway registrationGateway, ChampionShipEntityMapper championShipEntityMapper) {
        this.userGateway = userGateway;
        this.championshipGateway = championshipGateway;
        this.registrationGateway = registrationGateway;
        this.championShipEntityMapper = championShipEntityMapper;
    }

    @Override
    public List<Registration> findPendingRegistrations() {


        List<Championship> championships = findProprietaryChampionships();

        List<Registration> registrations = championships.stream()
                .flatMap(championship -> championship.registrationsId().stream())
                .map(registrationGateway::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(registration -> registration.status().equals(RegistrationStatus.PENDING))
                .toList();

        return registrations;
    }

    @Override
    public List<Championship> findProprietaryChampionships() {

        String authenticatedId = userGateway.getAuthenticatedUser().id();
//                .replaceAll("^\"|\"$","");

        List<Championship> allChampionships = championshipGateway.findAll();

        return allChampionships
                .stream()
                .filter( c -> c.createdBy().equals(authenticatedId))
                .collect(Collectors.toList()
                );
    }

    @Override
    public void manageRegistration(String registrationId, String status) {

        RegistrationStatus registrationStatus = RegistrationStatus.valueOf(status.toUpperCase());

        List<Registration> registrations = findPendingRegistrations();


        Map<String, Registration> registrationMap = new HashMap<>();


        for(Registration registration : registrations){
            registrationMap.put(registration.id(), registration);
        }


        Registration registration = registrationMap.get(registrationId);

        if(registration != null){
            Registration updatedRegistration= new Registration(registration.id(), registration.ownerId(), registration.championshipId(), registrationStatus);
            if(registrationStatus.equals(RegistrationStatus.REJECTED)){
                Championship championship = championshipGateway.findById(registration.championshipId()).orElse(null);
                ChampionshipEntity toUpdateChampionship = championShipEntityMapper.toEntity(championship);
                List<String> updatedRegistrations = championship.registrationsId().stream()
                        .filter(id -> !id.equals(updatedRegistration.id()))
                        .collect(Collectors.toList());
                toUpdateChampionship.setRegistrationsId(updatedRegistrations);
                championshipGateway.update(registration.championshipId(), championShipEntityMapper.toDomain(toUpdateChampionship));
            }
            registrationGateway.update(registrationId, updatedRegistration);
        }


    }

}
