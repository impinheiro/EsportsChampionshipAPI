package fan.esports.championship.Esports.Championship.core.usecases.championship;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;

import java.util.List;

public interface FindByGameNameCase {
    List<Championship> execute(String gameName);
}
