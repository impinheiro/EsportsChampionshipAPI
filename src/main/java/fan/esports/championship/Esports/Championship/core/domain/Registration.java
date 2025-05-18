package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

public record Registration (String id, String ownerId, String championshipId, RegistrationStatus status) {
}
