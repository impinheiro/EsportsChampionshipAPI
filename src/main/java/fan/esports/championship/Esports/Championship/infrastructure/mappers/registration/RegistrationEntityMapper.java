package fan.esports.championship.Esports.Championship.infrastructure.mappers.registration;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.RegistrationEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistrationEntityMapper {

    public RegistrationEntity toEntity(Registration registration) {

        return new RegistrationEntity(
                registration.id(),
                registration.ownerId(),
                registration.championshipId(),
                registration.status()
        );
    }
    public Registration toDomain(RegistrationEntity registrationEntity) {
        return new Registration(
                registrationEntity.getId(),
                registrationEntity.getOwnerdId(),
                registrationEntity.getChampionshipId(),
                registrationEntity.getStatus()
        );
    }
}
