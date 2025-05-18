package fan.esports.championship.Esports.Championship.core.usecases.registrations;

import fan.esports.championship.Esports.Championship.core.domain.Registration;

import java.util.List;
import java.util.Map;

public interface FindAllRegistrationsCase {
    List<Registration> execute();
}
