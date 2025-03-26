package fan.esports.championship.Esports.Championship.infrastructure.mappers;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.RegistrationDTO;
import org.springframework.stereotype.Component;

@Component
public class RegistrationDtoMapper {
    private final UserDtoMapper userMapper;

    public RegistrationDtoMapper(UserDtoMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Registration toDomain(RegistrationDTO registrationDTO){
        return new Registration(registrationDTO.id(),userMapper.toDomain(registrationDTO.userDTO()));
    }
    public RegistrationDTO toDTO(Registration registration){
        return new RegistrationDTO(registration.id(), userMapper.toDto(registration.user()));
    }
}
