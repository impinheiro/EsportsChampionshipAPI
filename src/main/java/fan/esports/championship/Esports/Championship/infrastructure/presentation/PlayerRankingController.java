package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.player.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewPlayerRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player.PlayerRankingDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/player-ranking")
public class PlayerRankingController {

    private PlayerRankingDtoMapper playerRankingDtoMapper;
    private final CreatePlayerRankingCase createPlayerRankingCase;
    private final FindPlayerRankingByIdCase findPlayerRankingByIdCase;
    private final FindPlayerRankingsCase findPlayerRankingsCase;
    private final UpdatePlayerRankingCase updatePlayerRankingCase;
    private final DeletePlayerRankingCase deletePlayerRankingCase;

    public PlayerRankingController(CreatePlayerRankingCase createPlayerRankingCase, FindPlayerRankingByIdCase findPlayerRankingByIdCase, FindPlayerRankingsCase findPlayerRankingsCase, UpdatePlayerRankingCase updatePlayerRankingCase, DeletePlayerRankingCase deletePlayerRankingCase) {
        this.createPlayerRankingCase = createPlayerRankingCase;
        this.findPlayerRankingByIdCase = findPlayerRankingByIdCase;
        this.findPlayerRankingsCase = findPlayerRankingsCase;
        this.updatePlayerRankingCase = updatePlayerRankingCase;
        this.deletePlayerRankingCase = deletePlayerRankingCase;
    }

    @PostMapping
    public ResponseEntity<PlayerRanking> create(@RequestBody NewPlayerRanking ranking) {

        PlayerRanking playerRanking = playerRankingDtoMapper.toDomain(ranking);

        createPlayerRankingCase.execute(playerRanking);

        return ResponseEntity.ok(playerRanking);
    }
}
