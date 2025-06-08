package fan.esports.championship.Esports.Championship.infrastructure.presentation;


import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.usecases.players.GetScheduledMatchesCase;
import fan.esports.championship.Esports.Championship.core.usecases.players.TrackChampionshipsCase;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.playermappings.PlayerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    private final PlayerMapper playerMapper;
    private final TrackChampionshipsCase trackChampionshipsCase;
    private final GetScheduledMatchesCase  getScheduledMatchesCase;

    public PlayerController(PlayerMapper playerMapper, TrackChampionshipsCase trackChampionshipsCase, GetScheduledMatchesCase getScheduledMatchesCase) {
        this.playerMapper = playerMapper;
        this.trackChampionshipsCase = trackChampionshipsCase;
        this.getScheduledMatchesCase = getScheduledMatchesCase;
    }

    @GetMapping("/getRegisteredChampionships")
    public ResponseEntity<?> getRegisteredChampionships() {
        Map<Registration, Championship> trackedChampionships = trackChampionshipsCase.execute();
        return ResponseEntity.ok(playerMapper.toDTO(trackedChampionships));
    }

    @GetMapping("/getScheduledMatches")
    public ResponseEntity<?> getScheduledMatches() {
        List<Match> scheduledMatches = getScheduledMatchesCase.execute();
        return ResponseEntity.ok(scheduledMatches);
    }
}
