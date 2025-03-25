package fan.esports.championship.Esports.Championship.core.domain;

import fan.esports.championship.Esports.Championship.core.enums.UserRole;

import java.time.LocalDateTime;
import java.util.Date;

public record User(String id,
                   String name,
                   String email,
                   String nickname,
                   String password,
                   Date birthday,
                   String profilePhoto,
                   UserRole role,
                   LocalDateTime createdAt,
                   LocalDateTime updatedAt) {
}
