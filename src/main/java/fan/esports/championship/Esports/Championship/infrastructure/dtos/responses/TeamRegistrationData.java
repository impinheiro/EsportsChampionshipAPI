package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;

public record TeamRegistrationData(String id,
                                   TeamData team,
                                   RegistrationStatus status) {
}
