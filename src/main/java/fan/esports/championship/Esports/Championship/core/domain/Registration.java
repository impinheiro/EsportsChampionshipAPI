package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

public record Registration (String id, User user, RegistrationStatus status) {
}
