package fan.esports.championship.Esports.Championship.infrastructure.mappers.user;

import fan.esports.championship.Esports.Championship.core.domain.UserInfo;
import fan.esports.championship.Esports.Championship.infrastructure.config.JWTUserData;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper {

    public UserInfo toUserInfo(JWTUserData jwtUserData) {
        return new UserInfo(jwtUserData.id(),jwtUserData.name(),jwtUserData.email(),jwtUserData.role());
    }
}
