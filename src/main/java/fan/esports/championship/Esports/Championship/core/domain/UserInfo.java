package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.enums.UserRole;

public record UserInfo(String id, String name, String email, UserRole role) {
}
