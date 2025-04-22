package fan.esports.championship.Esports.Championship.core.usecases.user;

import fan.esports.championship.Esports.Championship.core.domain.User;

public interface PromoteUserCase {
    User execute(String id, String role);
}
