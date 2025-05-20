package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.usecases.championship.FindChampionshipByIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.matches.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.MatchDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamMatchDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.matches.MatchDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/matches")
public class MatchController {

    private final FindMatchByIdCase findMatchByIdCase;
    private final FindAllMatchesCase findAllMatchesCase;
    private final UpdateMatchCase updateMatchCase;
    private final CreateMatchCase createMatchCase;
    private final DeleteMatchCase deleteMatchCase;
    private final MatchDtoMapper matchDtoMapper;
    private final FindChampionshipByIdCase findChampionshipByIdCase;

    public MatchController(FindMatchByIdCase findMatchByIdCase, FindAllMatchesCase findAllMatchesCase, UpdateMatchCase updateMatchCase, CreateMatchCase createMatchCase, DeleteMatchCase deleteMatchCase, MatchDtoMapper matchDtoMapper, FindChampionshipByIdCase findChampionshipByIdCase) {
        this.findMatchByIdCase = findMatchByIdCase;
        this.findAllMatchesCase = findAllMatchesCase;
        this.updateMatchCase = updateMatchCase;
        this.createMatchCase = createMatchCase;
        this.deleteMatchCase = deleteMatchCase;
        this.matchDtoMapper = matchDtoMapper;
        this.findChampionshipByIdCase = findChampionshipByIdCase;
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap<>();
        List<Match> matches = findAllMatchesCase.execute();
        response.put("Matches: ", matches.stream().map(matchDtoMapper::toDTO).toList());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        Match match = findMatchByIdCase.execute(id);
        response.put("Match found: ", matchDtoMapper.toDTO(match));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity <?> create (@RequestBody MatchDTO matchDTO) {
        Map<String, Object> response = new HashMap<>();
        Match match = matchDtoMapper.toDomain(matchDTO);
        createMatchCase.execute(match);
        response.put("Success: ", "Match was created");
        response.put("Info: ", matchDtoMapper.toDTO(match));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <?> update (@RequestBody MatchDTO matchDTO, @PathVariable String id) {
        Map<String, Object> response = new HashMap<>();

        Match match = matchDtoMapper.toDomain(matchDTO);

        Match updatedData = updateMatchCase.execute(id, match);

        response.put("Success: ", "Match was updated");
        response.put("Info: ", matchDtoMapper.toDTO(match));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> delete(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        deleteMatchCase.execute(id);
        response.put("Success: ", "Match was deleted");
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}
