package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.UserDTO;

import java.util.List;
import java.util.Optional;

public interface ChampionshipGateway {
     Championship create(Championship championship);
     Championship update(String id, Championship championship);
     void delete(String id);
     Optional<Championship> findById(String id);
     List<Championship> findAll();
     List<Championship> findAvailableChampionships();
     List<Championship> findExpiredChampionships();
     Championship subscribeMatch(String championshipId, String matchId);
     Championship subscribeRegistration(String championshipId, String registrationId);
}
