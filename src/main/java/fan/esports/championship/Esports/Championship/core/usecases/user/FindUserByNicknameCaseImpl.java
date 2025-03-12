package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;

public class FindUserByNicknameCaseImpl implements FindUserByNicknameCase {

    private UserGateway userGateway;

    public FindUserByNicknameCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(String nickname) {
        return userGateway.findByNickname(nickname).orElse(null);
    }
}
