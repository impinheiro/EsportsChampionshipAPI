package fan.esports.championship.Esports.Championship.core.usecases.promoters;

import fan.esports.championship.Esports.Championship.core.domain.Registration;

import java.util.List;

public interface FindPendingRegistrationsCase {
    List<Registration> execute();
}
