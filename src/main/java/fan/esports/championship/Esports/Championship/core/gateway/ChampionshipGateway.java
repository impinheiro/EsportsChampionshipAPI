package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;

import java.util.List;
import java.util.Optional;

public interface ChampionshipGateway {
     Championship create(Championship championship);
     Championship update(String id, Championship championship);
     void delete(String id);
     Optional<Championship> findById(String id);
     List<Championship> findAll();
}
