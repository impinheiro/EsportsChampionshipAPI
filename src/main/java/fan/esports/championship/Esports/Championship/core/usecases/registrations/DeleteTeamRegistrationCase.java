package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;

public interface DeleteTeamRegistrationCase {
    void execute(String id);
}
