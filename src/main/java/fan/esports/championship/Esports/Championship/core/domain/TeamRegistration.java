package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

public record TeamRegistration(String id, Team team, RegistrationStatus status) {
}
