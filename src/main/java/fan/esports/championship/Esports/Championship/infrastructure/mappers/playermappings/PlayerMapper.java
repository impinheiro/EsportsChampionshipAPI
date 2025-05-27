package fan.esports.championship.Esports.Championship.infrastructure.mappers.playermappings;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.TrackedChampionshipsDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    public List<TrackedChampionshipsDTO> toDTO(Map<Registration, Championship> trackedChampionships){
       return trackedChampionships.entrySet().stream().map(entry ->
                       new TrackedChampionshipsDTO(
                               entry.getValue().name(),
                               entry.getKey().id(),
                               String.valueOf(entry.getKey().status())))
                .collect(Collectors.toList());
    }
}
