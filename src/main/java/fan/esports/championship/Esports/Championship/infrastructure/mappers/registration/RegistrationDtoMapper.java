package fan.esports.championship.Esports.Championship.infrastructure.mappers.registration;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.RegistrationDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.RegistrationData;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class RegistrationDtoMapper {
    private final UserDtoMapper userMapper;

    public RegistrationDtoMapper(UserDtoMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Registration toDomain(RegistrationDTO registrationDTO){
        return new Registration(registrationDTO.id(),
                userMapper.toDomain(registrationDTO.user()),
                registrationDTO.status()
        );
    }

    public RegistrationDTO toDTO(Registration registration){
        return new RegistrationDTO(registration.id(),
                userMapper.toDto(registration.user()),
                registration.status()
        );
    }

    public RegistrationData toRegistrationData(Registration registration){
        return new RegistrationData(registration.id(),
                userMapper.toUserData(registration.user()),
                registration.status()
        );
    }
}
