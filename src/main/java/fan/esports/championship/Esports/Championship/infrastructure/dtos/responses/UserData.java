package fan.esports.championship.Esports.Championship.infrastructure.dtos.responses;

import java.util.Date;

public record UserData(String id,
                       String name,
                       String nickname,
                       String email,
                       Date birthday,
                       String profilePhoto) {
}
