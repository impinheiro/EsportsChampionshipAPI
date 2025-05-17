package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.team.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamRankingDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.team.TeamRankingDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/team-ranking")
public class TeamRankingController {

    private final TeamRankingDtoMapper teamRankingDtoMapper;
    private final CreateTeamRankingCase createTeamRankingCase;
    private final FindTeamRankingByIdCase findTeamRankingByIdCase;
    private final FindAllTeamRankingsCase findAllTeamRankingsCase;
    private final UpdateTeamRankingCase updateTeamRankingCase;
    private final DeleteTeamRankingCase deleteTeamRankingCase;

    public TeamRankingController(TeamRankingDtoMapper teamRankingDtoMapper, CreateTeamRankingCase createTeamRankingCase, FindTeamRankingByIdCase findTeamRankingByIdCase, FindAllTeamRankingsCase findAllTeamRankingsCase, UpdateTeamRankingCase updateTeamRankingCase, DeleteTeamRankingCase deleteTeamRankingCase) {
        this.teamRankingDtoMapper = teamRankingDtoMapper;
        this.createTeamRankingCase = createTeamRankingCase;
        this.findTeamRankingByIdCase = findTeamRankingByIdCase;
        this.findAllTeamRankingsCase = findAllTeamRankingsCase;
        this.updateTeamRankingCase = updateTeamRankingCase;
        this.deleteTeamRankingCase = deleteTeamRankingCase;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody NewRanking newRanking) {

        TeamRanking teamRanking = teamRankingDtoMapper.toDomain(newRanking);
        createTeamRankingCase.execute(teamRanking);

        return ResponseEntity.ok(teamRankingDtoMapper.toDto(teamRanking));
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll() {

        List<TeamRanking> teamRankings = findAllTeamRankingsCase.execute();
        return ResponseEntity.ok(teamRankings);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        TeamRanking teamRanking = findTeamRankingByIdCase.execute(id);
        return ResponseEntity.ok(teamRankingDtoMapper.toDto(teamRanking));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody TeamRankingDTO teamRankingDto) {

        TeamRanking teamRanking = teamRankingDtoMapper.toDomain(teamRankingDto);
        updateTeamRankingCase.execute(id, teamRanking);

        return ResponseEntity.ok(teamRankingDtoMapper.toDto(teamRanking));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        deleteTeamRankingCase.execute(id);

        return ResponseEntity.ok().build();
    }
}
