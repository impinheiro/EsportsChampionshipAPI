package fan.esports.championship.Esports.Championship.core.usecases.promoters;

import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;

import java.util.List;

public interface FindPendingTeamRegistrationsCase {
    List<TeamRegistration> execute();
}
