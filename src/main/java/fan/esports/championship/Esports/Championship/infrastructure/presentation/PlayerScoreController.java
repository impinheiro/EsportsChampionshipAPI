package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.core.usecases.scores.player.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.PlayerScoreDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.players.PlayerScoreDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/player-scores")
public class PlayerScoreController {

    private final PlayerScoreDtoMapper playerScoreDtoMapper;
    private final CreatePlayerScoreCase createPlayerScoreCase;
    private final FindPlayerScoreByIdCase findPlayerScoreByIdCase;
    private final FindPlayerScoresCase findPlayerScoresCase;
    private final UpdatePlayerScoreCase updatePlayerScoreCase;
    private final DeletePlayerScoreCase deletePlayerScoreCase;

    public PlayerScoreController(PlayerScoreDtoMapper playerScoreDtoMapper, CreatePlayerScoreCase createPlayerScoreCase, FindPlayerScoreByIdCase findPlayerScoreByIdCase, FindPlayerScoresCase findPlayerScoresCase, UpdatePlayerScoreCase updatePlayerScoreCase, DeletePlayerScoreCase deletePlayerScoreCase) {
        this.playerScoreDtoMapper = playerScoreDtoMapper;
        this.createPlayerScoreCase = createPlayerScoreCase;
        this.findPlayerScoreByIdCase = findPlayerScoreByIdCase;
        this.findPlayerScoresCase = findPlayerScoresCase;
        this.updatePlayerScoreCase = updatePlayerScoreCase;
        this.deletePlayerScoreCase = deletePlayerScoreCase;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPlayerScore(@RequestBody PlayerScoreDTO playerScoreDTO) {
        PlayerScore playerScore= playerScoreDtoMapper.toDomain(playerScoreDTO);
        createPlayerScoreCase
    }
}
