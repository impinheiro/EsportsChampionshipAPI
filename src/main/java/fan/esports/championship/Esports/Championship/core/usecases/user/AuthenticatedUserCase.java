package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.UserInfo;

public interface AuthenticatedUserCase {
    UserInfo getAuthenticatedUser();
}
