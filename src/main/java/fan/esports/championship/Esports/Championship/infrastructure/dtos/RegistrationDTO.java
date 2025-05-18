package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

public record RegistrationDTO(String id, String ownerId, String championshipId, RegistrationStatus status) {
}
