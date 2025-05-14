package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.TeamRegistrationEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.RegistrationEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.RegistrationRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.TeamRegistrationEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.TeamRegistrationRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class RegistrationRepositoryGateway implements RegistrationGateway {

    private final RegistrationRepository registrationRepository;
    private final RegistrationEntityMapper registrationEntityMapper;
    private final TeamRegistrationRepository teamRegistrationRepository;
    private final TeamRegistrationEntityMapper teamRegistrationEntityMapper;

    public RegistrationRepositoryGateway(RegistrationRepository registrationRepository, RegistrationEntityMapper registrationEntityMapper, TeamRegistrationRepository teamRegistrationRepository, TeamRegistrationEntityMapper teamRegistrationEntityMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationEntityMapper = registrationEntityMapper;
        this.teamRegistrationRepository = teamRegistrationRepository;
        this.teamRegistrationEntityMapper = teamRegistrationEntityMapper;
    }


    @Override
    public Registration create(Registration registration) {
        RegistrationEntity newRegistration = registrationEntityMapper.toEntity(registration);
        newRegistration.setStatus(RegistrationStatus.PENDING);
        registrationRepository.save(newRegistration);
        return registrationEntityMapper.toDomain(newRegistration);
    }

    @Override
    public Registration update(String id, Registration registration) {
        RegistrationEntity toUpdate = registrationRepository.findById(id).orElse(null);
        RegistrationEntity registrationData = registrationEntityMapper.toEntity(registration);
        toUpdate.setUser(registrationData.getUser());
        toUpdate.setStatus(registrationData.getStatus());
        registrationRepository.save(toUpdate);
        return registrationEntityMapper.toDomain(toUpdate);
    }

    @Override
    public Optional<Registration> findById(String id) {
        RegistrationEntity foundRegistration = registrationRepository.findById(id).orElse(null);
        if (foundRegistration != null) {
            return Optional.of(registrationEntityMapper.toDomain(foundRegistration));
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        RegistrationEntity toDelete = registrationRepository.findById(id).orElse(null);
        registrationRepository.delete(toDelete);
    }

    @Override
    public TeamRegistration createTeamRegistration(TeamRegistration teamRegistration) {
        TeamRegistrationEntity teamRegistrationData = teamRegistrationEntityMapper.toEntity(teamRegistration);
        teamRegistrationRepository.save(teamRegistrationData);
        return teamRegistrationEntityMapper.toDomain(teamRegistrationData);
    }

    @Override
    public TeamRegistration updateTeamRegistration(String id, TeamRegistration teamRegistration) {
        TeamRegistrationEntity teamRegistrationData = teamRegistrationRepository.findById(id).orElse(null);
        TeamRegistrationEntity updatedData = teamRegistrationEntityMapper.toEntity(teamRegistration);
        teamRegistrationData.setTeam(updatedData.getTeam());
        teamRegistrationData.setStatus(updatedData.getStatus());
        teamRegistrationRepository.save(teamRegistrationData);
        return teamRegistrationEntityMapper.toDomain(teamRegistrationData);
    }

    @Override
    public Optional<TeamRegistration> findTeamRegistrationById(String id) {
        TeamRegistrationEntity teamRegistrationData = teamRegistrationRepository.findById(id).orElse(null);
        if (teamRegistrationData != null) {
            return Optional.of(
                    teamRegistrationEntityMapper.toDomain(teamRegistrationData)
            );
        }
        return Optional.empty();
    }

    @Override
    public void deleteTeamRegistration(String id) {
        TeamRegistrationEntity teamRegistrationData = teamRegistrationRepository.findById(id).orElse(null);
        teamRegistrationRepository.delete(teamRegistrationData);
    }

    @Override
    public Map<String, Object> findAll() {
        Map<String, Object> result = new HashMap<>();
        result.put("User registrations", registrationRepository.findAll());
        result.put("Team registrations", teamRegistrationRepository.findAll());
        return result;
    }
}
