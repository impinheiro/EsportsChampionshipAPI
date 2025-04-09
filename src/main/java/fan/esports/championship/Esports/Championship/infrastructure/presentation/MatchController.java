package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.usecases.matches.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.MatchDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamMatchDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.matches.MatchDtoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.matches.TeamMatchDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/matches")
public class MatchController {

    private final FindMatchByIdCase findMatchByIdCase;
    private final FindAllMatchesCase findAllMatchesCase;
    private final UpdateMatchCase updateMatchCase;
    private final CreateMatchCase createMatchCase;
    private final DeleteMatchCase deleteMatchCase;
    private final FindTeamMatchByIdCase findTeamMatchByIdCase;
    private final FindAllTeamMatchesCase findAllTeamMatchesCase;
    private final UpdateTeamMatchCase updateTeamMatchCase;
    private final CreateTeamMatchCase createTeamMatchCase;
    private final DeleteTeamMatchCase deleteTeamMatchCase;
    private final MatchDtoMapper matchDtoMapper;
    private final TeamMatchDtoMapper teamMatchDtoMapper;

    public MatchController(FindMatchByIdCase findMatchByIdCase, FindAllMatchesCase findAllMatchesCase, UpdateMatchCase updateMatchCase, CreateMatchCase createMatchCase, DeleteMatchCase deleteMatchCase, FindTeamMatchByIdCase findTeamMatchByIdCase, FindAllTeamMatchesCase findAllTeamMatchesCase, UpdateTeamMatchCase updateTeamMatchCase, CreateTeamMatchCase createTeamMatchCase, DeleteTeamMatchCase deleteTeamMatchCase, MatchDtoMapper matchDtoMapper, TeamMatchDtoMapper teamMatchDtoMapper) {
        this.findMatchByIdCase = findMatchByIdCase;
        this.findAllMatchesCase = findAllMatchesCase;
        this.updateMatchCase = updateMatchCase;
        this.createMatchCase = createMatchCase;
        this.deleteMatchCase = deleteMatchCase;
        this.findTeamMatchByIdCase = findTeamMatchByIdCase;
        this.findAllTeamMatchesCase = findAllTeamMatchesCase;
        this.updateTeamMatchCase = updateTeamMatchCase;
        this.createTeamMatchCase = createTeamMatchCase;
        this.deleteTeamMatchCase = deleteTeamMatchCase;
        this.matchDtoMapper = matchDtoMapper;
        this.teamMatchDtoMapper = teamMatchDtoMapper;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("Matches: ", findAllMatchesCase.execute());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        Match match = findMatchByIdCase.execute(id);
        response.put("Match found: ", match);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity <?> create (@RequestBody MatchDTO matchDTO) {
        Map<String, Object> response = new HashMap<>();
        Match match = matchDtoMapper.toDomain(matchDTO);
        createMatchCase.execute(match);
        response.put("Success: ", "Match was created");
        response.put("Info: ", matchDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <?> update (@RequestBody MatchDTO matchDTO, @PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        Match match = matchDtoMapper.toDomain(matchDTO);
        updateMatchCase.execute(id, match);
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

    @PostMapping("/teammatch/create")
    public ResponseEntity<?> createTeamMatch (@RequestBody TeamMatchDTO teamMatchDTO) {
        Map<String, Object> response = new HashMap<>();
        TeamMatch teamMatch = teamMatchDtoMapper.toDomain(teamMatchDTO);
        createTeamMatchCase.execute(teamMatch);
        response.put("Success: ", "Match was created");
        response.put("Info: ", teamMatchDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/teammatch/delete/{id}")
    public ResponseEntity<?> deleteTeamMatch (@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        deleteTeamMatchCase.execute(id);
        response.put("Success: ", "Match was deleted");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @PutMapping("/teammatch/update/{id}")
    public ResponseEntity<?> updateTeamMatch (@RequestBody TeamMatchDTO teamMatchDTO, @PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        TeamMatch teamMatch = teamMatchDtoMapper.toDomain(teamMatchDTO);
        updateTeamMatchCase.execute(id, teamMatch);
        response.put("Success: ", "Match was updated");
        response.put("Info: ", teamMatchDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/teammatch/findById/{id}")
    public ResponseEntity<?> findTeamMatchById(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        TeamMatch teamMatch = findTeamMatchByIdCase.execute(id);
        response.put("Success: ", "Match was found");
        response.put("Info: ", teamMatch);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/teammatch/findAll")
    public ResponseEntity<?> findAllTeamMatches() {
        Map<String, Object> response = new HashMap<>();
        response.put("Matches: ", findAllTeamMatchesCase.execute());
        return ResponseEntity.ok(response);
    }
}
