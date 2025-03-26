package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.Registration;

public interface UpdateRegistrationCase {
    Registration execute(String id, Registration registration);
}
