package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

public record RegistrationDTO(String id, UserDTO user, RegistrationStatus status) {
}
