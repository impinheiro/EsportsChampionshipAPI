package fan.esports.championship.Esports.Championship.core.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipFormat;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;

import java.util.List;
import java.util.Optional;

public interface ChampionshipGateway {
     Championship create(Championship championship);
     Championship update(String id, Championship championship);
     void delete(String id);
     Optional<Championship> findById(String id);
     List<Championship> findByGameName(String gameName);
     List<Championship> findByChampionshipType(String championshipType);
     List<Championship> findByChampionshipFormat(String championshipFormat);
     List<Championship> findAll();
     List<Championship> findAvailableChampionships();
     List<Championship> findExpiredChampionships();
     Championship subscribeMatch(String championshipId, String matchId);
     Championship subscribeRegistration(String championshipId, String registrationId);
}
