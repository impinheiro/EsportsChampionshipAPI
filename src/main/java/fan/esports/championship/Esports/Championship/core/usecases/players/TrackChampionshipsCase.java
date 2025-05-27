package fan.esports.championship.Esports.Championship.core.usecases.players;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;

import java.util.List;
import java.util.Map;

public interface TrackChampionshipsCase {
    Map<Registration, Championship> execute();
}
