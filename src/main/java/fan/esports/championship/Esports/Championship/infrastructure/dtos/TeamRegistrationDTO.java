package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

public record TeamRegistrationDTO(String id, TeamDTO team, RegistrationStatus status) {
}
