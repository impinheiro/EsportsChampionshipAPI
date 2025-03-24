package fan.esports.championship.Esports.Championship.infrastructure.config;

import fan.esports.championship.Esports.Championship.core.enums.UserRole;
import lombok.Builder;

@Builder
public record JWTUserData(String id, String name, String email, UserRole role) {
}
