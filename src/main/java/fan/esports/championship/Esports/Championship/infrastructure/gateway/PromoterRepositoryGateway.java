package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.PromoterGateway;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PromoterRepositoryGateway implements PromoterGateway {

    private final UserRepositoryGateway userGateway;
    private final ChampionshipRepositoryGateway championshipGateway;
    private final RegistrationRepositoryGateway registrationGateway;

    public PromoterRepositoryGateway(UserRepositoryGateway userGateway, ChampionshipRepositoryGateway championshipGateway, RegistrationRepositoryGateway registrationGateway) {
        this.userGateway = userGateway;
        this.championshipGateway = championshipGateway;
        this.registrationGateway = registrationGateway;
    }

    @Override
    public List<Registration> findPendingRegistrations() {

        String authenticatedUserId = userGateway.getAuthenticatedUser().id().replaceAll("^\"|\"$", "");

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
    public List<TeamRegistration> findPendingTeamRegistrations() {

        String authenticatedId = userGateway.getAuthenticatedUser().id().replaceAll("^\"|\"$", "");

        List<Championship> championships = findProprietaryChampionships();

        List<TeamRegistration> registrations = championships.stream()
                .flatMap(championship -> championship.registrationsId().stream())
                .map(registrationGateway::findTeamRegistrationById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(registration -> registration.status().name().equals(RegistrationStatus.PENDING.name()))
                .toList();

        return registrations;
    }

    @Override
    public List<Championship> findProprietaryChampionships() {

        String authenticatedId = userGateway.getAuthenticatedUser().id().replaceAll("^\"|\"$","");

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

        List<Registration> userRegistrations = findPendingRegistrations();

        List<TeamRegistration> teamRegistrations = findPendingTeamRegistrations();

        Map<String, Registration> userRegistrationMap = new HashMap<>();

        Map<String, TeamRegistration> teamRegistrationMap = new HashMap<>();

        for(Registration registration : userRegistrations){
            userRegistrationMap.put(registration.id(), registration);
        }

        for(TeamRegistration teamRegistration : teamRegistrations){
            teamRegistrationMap.put(teamRegistration.id(), teamRegistration);
        }

        Registration registration = userRegistrationMap.get(registrationId);

        TeamRegistration teamRegistration = teamRegistrationMap.get(registrationId);

        if(registration != null){
            Registration updatedRegistration= new Registration(registration.id(), registration.user(), registrationStatus);
            registrationGateway.update(registrationId, updatedRegistration);
        }
        if(teamRegistration != null){
            TeamRegistration updatedTeamRegistration= new TeamRegistration(teamRegistration.id(), teamRegistration.team(), registrationStatus);
            registrationGateway.updateTeamRegistration(registrationId, updatedTeamRegistration);
        }

    }

}
