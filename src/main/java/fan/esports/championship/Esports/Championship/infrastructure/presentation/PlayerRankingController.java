package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.usecases.championship.FindChampionshipByIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.player.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.PlayerRankingDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player.PlayerRankingDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/player-ranking")
public class PlayerRankingController {

    private PlayerRankingDtoMapper playerRankingDtoMapper;
    private final FindChampionshipByIdCase findChampionshipByIdCase;
    private final CreatePlayerRankingCase createPlayerRankingCase;
    private final FindPlayerRankingByIdCase findPlayerRankingByIdCase;
    private final FindPlayerRankingsCase findPlayerRankingsCase;
    private final UpdatePlayerRankingCase updatePlayerRankingCase;
    private final DeletePlayerRankingCase deletePlayerRankingCase;

    public PlayerRankingController(FindChampionshipByIdCase findChampionshipByIdCase, CreatePlayerRankingCase createPlayerRankingCase, FindPlayerRankingByIdCase findPlayerRankingByIdCase, FindPlayerRankingsCase findPlayerRankingsCase, UpdatePlayerRankingCase updatePlayerRankingCase, DeletePlayerRankingCase deletePlayerRankingCase) {
        this.findChampionshipByIdCase = findChampionshipByIdCase;
        this.createPlayerRankingCase = createPlayerRankingCase;
        this.findPlayerRankingByIdCase = findPlayerRankingByIdCase;
        this.findPlayerRankingsCase = findPlayerRankingsCase;
        this.updatePlayerRankingCase = updatePlayerRankingCase;
        this.deletePlayerRankingCase = deletePlayerRankingCase;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody NewRanking ranking) {

        PlayerRanking playerRanking = playerRankingDtoMapper.toDomain(ranking);
        createPlayerRankingCase.execute(playerRanking);

        return ResponseEntity.ok(playerRanking);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        PlayerRanking playerRanking = findPlayerRankingByIdCase.execute(id);

        return ResponseEntity.ok(playerRanking);

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<PlayerRanking> playerRankings = findPlayerRankingsCase.execute();

        return ResponseEntity.ok(playerRankings);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody PlayerRankingDTO playerRankingDto) {

        PlayerRanking playerRanking = playerRankingDtoMapper.toDomain(playerRankingDto);
        updatePlayerRankingCase.execute(id, playerRanking);
        return ResponseEntity.ok(playerRanking);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        deletePlayerRankingCase.execute(id);
        return ResponseEntity.ok().build();
    }
}
