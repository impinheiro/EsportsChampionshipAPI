package fan.esports.championship.Esports.Championship.infrastructure.mappers.registration;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.registration.RegistrationEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistrationEntityMapper {

    private final UserEntityMapper userEntityMapper;

    public RegistrationEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public RegistrationEntity toEntity(Registration registration) {
        return new RegistrationEntity(userEntityMapper.toEntity(registration.user()),registration.id());
    }
    public Registration toDomain(RegistrationEntity registrationEntity) {
        return new Registration(registrationEntity.getId(), userEntityMapper.toDomain(registrationEntity.getUser()));
    }
}
