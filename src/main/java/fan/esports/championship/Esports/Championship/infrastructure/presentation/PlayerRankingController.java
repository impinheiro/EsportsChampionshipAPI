package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.usecases.championship.FindChampionshipByIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.RankingDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.RankingDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/player-ranking")
public class PlayerRankingController {

    private RankingDtoMapper rankingDtoMapper;
    private final FindChampionshipByIdCase findChampionshipByIdCase;
    private final CreateRankingCase createPlayerRankingCase;
    private final FindRankingByIdCase findPlayerRankingByIdCase;
    private final FindAllRankingsCase findPlayerRankingsCase;
    private final UpdateRankingCase updatePlayerRankingCase;
    private final DeleteRankingCase deletePlayerRankingCase;

    public PlayerRankingController(FindChampionshipByIdCase findChampionshipByIdCase, CreateRankingCase createPlayerRankingCase, FindRankingByIdCase findPlayerRankingByIdCase, FindAllRankingsCase findPlayerRankingsCase, UpdateRankingCase updatePlayerRankingCase, DeleteRankingCase deletePlayerRankingCase) {
        this.findChampionshipByIdCase = findChampionshipByIdCase;
        this.createPlayerRankingCase = createPlayerRankingCase;
        this.findPlayerRankingByIdCase = findPlayerRankingByIdCase;
        this.findPlayerRankingsCase = findPlayerRankingsCase;
        this.updatePlayerRankingCase = updatePlayerRankingCase;
        this.deletePlayerRankingCase = deletePlayerRankingCase;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody NewRanking ranking) {

        Ranking playerRanking = rankingDtoMapper.toDomain(ranking);
        createPlayerRankingCase.execute(playerRanking);

        return ResponseEntity.ok(playerRanking);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        Ranking playerRanking = findPlayerRankingByIdCase.execute(id);

        return ResponseEntity.ok(playerRanking);

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<Ranking> playerRankings = findPlayerRankingsCase.execute();

        return ResponseEntity.ok(playerRankings);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody RankingDTO rankingDto) {

        Ranking playerRanking = rankingDtoMapper.toDomain(rankingDto);
        updatePlayerRankingCase.execute(id, playerRanking);
        return ResponseEntity.ok(playerRanking);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        deletePlayerRankingCase.execute(id);
        return ResponseEntity.ok().build();
    }
}
