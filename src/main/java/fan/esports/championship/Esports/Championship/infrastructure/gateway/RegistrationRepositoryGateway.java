package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.infrastructure.config.JWTUserData;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.RegistrationEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.RegistrationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RegistrationRepositoryGateway implements RegistrationGateway {


    private final RegistrationRepository registrationRepository;
    private final RegistrationEntityMapper registrationEntityMapper;

    public RegistrationRepositoryGateway(RegistrationRepository registrationRepository, RegistrationEntityMapper registrationEntityMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationEntityMapper = registrationEntityMapper;
    }


    @Override
    public Registration create(Registration registration) {
        RegistrationEntity newRegistration = registrationEntityMapper.toEntity(registration);
        JWTUserData userData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userId = userData.id();
//                .replaceAll("^\"|\"$", "");
        if(registration.ownerId() == null){
            newRegistration.setOwnerdId(userId);
        }
        newRegistration.setStatus(RegistrationStatus.PENDING);
        registrationRepository.save(newRegistration);
        return registrationEntityMapper.toDomain(newRegistration);
    }

    @Override
    public Registration update(String id, Registration registration) {
        RegistrationEntity toUpdate = registrationRepository.findById(id).orElse(null);
        RegistrationEntity registrationData = registrationEntityMapper.toEntity(registration);
        toUpdate.setOwnerdId(registrationData.getOwnerdId());
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
    public List<Registration> findAll() {

        return registrationRepository.findAll()
                .stream()
                .map(registrationEntityMapper::toDomain)
                .collect(Collectors.toList()
                );
    }

    @Override
    public void delete(String id) {
        RegistrationEntity toDelete = registrationRepository.findById(id).orElse(null);
        registrationRepository.delete(toDelete);
    }

}
