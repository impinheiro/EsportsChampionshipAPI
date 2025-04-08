package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;

public interface FindTeamRegistrationByIdCase {
    TeamRegistration execute(String id);
}
