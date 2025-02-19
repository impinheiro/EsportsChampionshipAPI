package fan.esports.championship.Esports.Championship.infrastructure.dtos;

import fan.esports.championship.Esports.Championship.core.enums.UserRole;

import java.util.Date;

public record UserDto(String id, String nome, String email, String nickname, String password, Date birthday, String profilePhoto, UserRole role) {
}
