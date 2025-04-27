package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import java.time.LocalDateTime;

public record RegistrationProof(String ownerName, LocalDateTime championshipDate, String rules, String award) {
}
